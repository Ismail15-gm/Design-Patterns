package entites;

import Factories.ConcreteFactory;

import java.util.ArrayList;
import java.util.List;


public class Company {

    String CEO;
    List<Factory> factories;

    private Company() {
        factories = new ArrayList<>();
    }

    private void setCEO(String CEO){
        this.CEO = CEO;
    }

    private void setFactories(List<Factory> factories){
        this.factories = factories;
    }


    public String report() {
        StringBuilder sb = new StringBuilder();

        // CEO (remove spaces)
        sb.append(CEO.replace(" ", "")).append(":|");

        for (int i = 0; i < factories.size(); i++) {
            Factory factory = factories.get(i);
            String country = factory.getCountry(); // assuming Factory has getCountry()
            char prefix = Character.toUpperCase(country.charAt(0));

            sb.append(prefix).append(":<");

            List<WareHouse> warehouses = factory.getWareHouses(); // assuming Factory has getWarehouses()

            for (int j = 0; j < warehouses.size(); j++) {
                WareHouse w = warehouses.get(j);
                sb.append(prefix)
                        .append("e").append(j + 1)
                        .append(":")
                        .append(w.getEmployees())
                        .append("-")
                        .append(w.getStock());

                if (j < warehouses.size() - 1) sb.append(",");
            }

            sb.append(">");

            if (i < factories.size() - 1) sb.append(", ");
        }

        sb.append("|");
        return sb.toString();
    }



    static public class CompanyBuilder {
        String CEO;
        List<Factory> factories;

        public CompanyBuilder(){   
            this.factories = new ArrayList<>();
        }

        public CompanyBuilder setCEO(String ceo) {
            this.CEO = ceo;
            return this;
        }

        public CompanyBuilder addFactory(String... data) {
            
            ConcreteFactory concreteFactory = new ConcreteFactory(); //CreateFactory
            Factory factory = concreteFactory.createFactory(data);

            this.factories.add(factory);

            return this;
        }

        public Company build() {
            Company company = new Company();
            company.setCEO(this.CEO);
            company.setFactories(this.factories);
            return company;
        }

    }
}