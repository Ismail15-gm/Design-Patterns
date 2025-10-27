package entites;
import entites.interfaces.Factory;

import java.util.ArrayList;
import java.util.List;

public class Factory1 implements Factory {
    String country;
    List<WareHouse> weareHouses;

    public Factory1(){
        this.weareHouses = new ArrayList<>();
    }

    public void setCountry(String c){
        this.country = c;
    }

    public void addWareHouse(WareHouse wareHouse){
        this.weareHouses.add(wareHouse);
    }


    public String getCountry() {
        return this.country;
    }

    public List<WareHouse> getWareHouses() {
        return weareHouses;
    }
}
