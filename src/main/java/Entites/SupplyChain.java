//package Entites;
//
//import Interfaces.Factory;
//
//import java.util.*;
//
//public class SupplyChain {
//    private Company[] companies;
//    private List<LogisticsRoute> network;
//
//    private SupplyChain() {}
//
//    public Company[] getCompanies() { return companies; }
//    public List<LogisticsRoute> getNetwork() { return network; }
//
//    public void prepareOrder() {
//        if (companies[0] == null || companies[1] == null) {
//            System.out.println("Both companies must be set");
//            return;
//        }
//
//        // 1. Find which company has higher capacity
//        int capacity0 = companies[0].currentProductionCapacity();
//        int capacity1 = companies[1].currentProductionCapacity();
//
//        Company preparingCompany = (capacity0 >= capacity1) ? companies[0] : companies[1];
//        Company targetCompany = (capacity0 >= capacity1) ? companies[1] : companies[0];
//
//        System.out.println("Company preparing order: " + preparingCompany.getCEO() +
//                " (Capacity: " + preparingCompany.currentProductionCapacity() + ")");
//
//        // 2. Find closest factory to the target company
//        Factory closestFactory = findClosestFactory(preparingCompany, targetCompany);
//
//        if (closestFactory != null) {
//            // 3. Move 40% of stock to transit
//            int stockBefore = closestFactory.getTotalCapacity();
//            closestFactory.moveStockToTransit(0.4);
//            int stockMoved = stockBefore - closestFactory.getTotalCapacity();
//
//            System.out.println("Moved " + stockMoved + " units from " +
//                    closestFactory.getCountry() + " factory to transit");
//        }
//    }
//
//    private Factory findClosestFactory(Company fromCompany, Company toCompany) {
//        Factory closestFactory = null;
//        int shortestDistance = Integer.MAX_VALUE;
//
//        // For each factory in the preparing company
//        for (Factory sourceFactory : fromCompany.getFactories()) {
//            // Find the minimum distance to any factory in the target company
//            int minDistance = getMinDistanceToCompany(sourceFactory, toCompany);
//
//            if (minDistance < shortestDistance) {
//                shortestDistance = minDistance;
//                closestFactory = sourceFactory;
//            }
//        }
//
//        if (closestFactory != null) {
//            System.out.println("Closest factory: " + closestFactory.getCountry() +
//                    " (Distance: " + shortestDistance + "km)");
//        }
//
//        return closestFactory;
//    }
//
//    private int getMinDistanceToCompany(Factory sourceFactory, Company targetCompany) {
//        int minDistance = Integer.MAX_VALUE;
//
//        for (Factory targetFactory : targetCompany.getFactories()) {
//            int distance = getDistanceBetweenCountries(
//                    sourceFactory.getCountry(),
//                    targetFactory.getCountry()
//            );
//            if (distance < minDistance) {
//                minDistance = distance;
//            }
//        }
//
//        return minDistance;
//    }
//
//    private int getDistanceBetweenCountries(String country1, String country2) {
//        for (LogisticsRoute route : network) {
//            if (route.connectsCountries(country1, country2)) {
//                return route.distanceKm();
//            }
//        }
//        return Integer.MAX_VALUE; // No route found
//    }
//
//    // Logistics Route Record
//    public record LogisticsRoute(String fromCountry, String toCountry, int distanceKm) {
//        public boolean connectsCountries(String country1, String country2) {
//            return (fromCountry.equals(country1) && toCountry.equals(country2)) ||
//                    (fromCountry.equals(country2) && toCountry.equals(country1));
//        }
//    }
//
//    // Builder
//    public static class SupplyChainBuilder {
//        private Company[] companies;
//        private List<LogisticsRoute> network;
//
//        public SupplyChainBuilder() {
//            companies = new Company[2];
//            network = new ArrayList<>();
//        }
//
//        public SupplyChainBuilder addCompany(Company company) {
//            if (companies[0] == null) {
//                companies[0] = company;
//            } else if (companies[1] == null) {
//                companies[1] = company;
//            } else {
//                throw new IllegalStateException("Only two companies allowed");
//            }
//            return this;
//        }
//
//        public SupplyChainBuilder addLogisticsNetwork(String networkString) {
//            if (networkString != null && !networkString.trim().isEmpty()) {
//                String[] routes = networkString.split(",");
//                for (String route : routes) {
//                    String[] parts = route.split(":");
//                    if (parts.length == 3) {
//                        network.add(new LogisticsRoute(
//                                parts[0].trim(),
//                                parts[2].trim(),
//                                Integer.parseInt(parts[1].trim())
//                        ));
//                    }
//                }
//            }
//            return this;
//        }
//
//        public SupplyChain build() {
//            if (companies[0] == null || companies[1] == null) {
//                throw new IllegalStateException("Both companies must be set");
//            }
//
//            SupplyChain supplyChain = new SupplyChain();
//            supplyChain.companies = this.companies;
//            supplyChain.network = this.network;
//            return supplyChain;
//        }
//    }
//}