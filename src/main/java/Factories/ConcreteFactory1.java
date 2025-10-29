package Factories;

import Entites.Factory1;
import Entites.WareHouse;
import Interfaces.Factory;

public class ConcreteFactory1 extends AbstractFactory {

    @Override
    public Factory createFactory(String... data){
        Factory1 factory1 = new Factory1();
        factory1.setCountry(data[0]);

        for(int i = 1 ; i < data.length ; i = i + 2){
            WareHouse wareHouse = new WareHouse(data[i] , data[i+1]);
            factory1.addWareHouse(wareHouse);
        }
        return factory1;

    }
}
