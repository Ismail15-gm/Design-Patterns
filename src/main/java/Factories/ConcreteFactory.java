package Factories;

import entites.Factory;
import entites.WareHouse;

public class ConcreteFactory extends AbstractFactory {

    @Override
    public Factory createFactory(String... data){

        Factory factory = new Factory();
        factory.setCountry(data[0]);

        for(int i = 1 ; i < data.length ; i = i + 2){
            WareHouse wareHouse = new WareHouse(data[i] , data[i+1]);
            factory.addWareHouse(wareHouse);
        }
        return factory;

    }
}
