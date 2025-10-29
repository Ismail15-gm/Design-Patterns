package Interfaces;
import Entites.WareHouse;

public interface Factory {

    void addWareHouse(WareHouse wareHouse);
    int getTotalCapacity();
    String getCountry();
}
