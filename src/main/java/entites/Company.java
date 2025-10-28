package entites;

import Factories.ConcreteFactory1;
import entites.interfaces.Factory;

import java.util.ArrayList;
import java.util.List;


public class Company {

    private String CEO;
    private List<Factory> factories;
    private String transitStock;

    private Company() {
        factories = new ArrayList<>();
    }

    public void setCEO(String CEO){
        this.CEO = CEO;
    }

    public void setFactories(List<Factory> factories){
        this.factories = factories;
    }

    public void setTransitStock(String transitStock){
        this.transitStock = transitStock;
    }


    public String report() {
        StringBuilder sb = new StringBuilder();

        // CEO (remove spaces)
        sb.append(CEO.replace(" ", "")).append(":|");

        for (int i = 0; i < factories.size(); i++) {
            Factory1 Factory1 = (Factory1) factories.get(i);
            sb.append(Factory1.toString());

            if (i < factories.size() - 1) {
                if(this.transitStock != null && Integer.parseInt(this.transitStock) > 0)
                    sb.append('-').append(this.transitStock);
                sb.append(", ");
            }
        }

        if(this.transitStock != null && Integer.parseInt(this.transitStock) > 0)
            sb.append('-').append(this.transitStock);
        sb.append("|");
        return sb.toString();
    }

    public int currentProductionCapacity() {
        int totalCapacity = 0;
        for(Factory f : factories)
            totalCapacity += f.getTotalCapacity();
        return totalCapacity;
    }

    static public class CompanyBuilder {
        String CEO;
        List<Factory> factories;
        String transitStock;

        public CompanyBuilder(){   
            this.factories = new ArrayList<>();
        }

        public CompanyBuilder setCEO(String ceo) {
            this.CEO = ceo;
            return this;
        }

        public CompanyBuilder addTransitStock(String transitStock){
            this.transitStock = transitStock;
            return this;
        }

        public CompanyBuilder addFactory(String... data) {
            
            ConcreteFactory1 concreteFactory1 = new ConcreteFactory1(); //CreateFactory
            Factory1 Factory1 = (Factory1) concreteFactory1.createFactory(data);

            this.factories.add(Factory1);

            return this;
        }

        public Company build() {
            Company company = new Company();
            company.setCEO(this.CEO);
            company.setFactories(this.factories);
            company.setTransitStock(this.transitStock);//did I violate the open/close principal when I did modify this ?
            return company;
        }
    }
}
