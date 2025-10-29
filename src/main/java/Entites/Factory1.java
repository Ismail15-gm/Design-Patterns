package Entites;
import Interfaces.Factory;

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

    public int getTotalCapacity(){
        int totalCapacity = 0;
        for( WareHouse w : weareHouses )
            totalCapacity += Integer.parseInt(w.getStock());
        return totalCapacity;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        String country = this.getCountry();
        char prefix = Character.toUpperCase(country.charAt(0));

        res.append(prefix).append(":<");

        List<WareHouse> warehouses = this.getWareHouses();

        for (int j = 0; j < warehouses.size(); j++) {
            WareHouse w = warehouses.get(j);
            res.append(prefix)
                    .append("e").append(j + 1)
                    .append(w.toString());

            if (j < warehouses.size() - 1) res.append(",");
        }
        res.append(">");

        return res.toString();
    }
}
