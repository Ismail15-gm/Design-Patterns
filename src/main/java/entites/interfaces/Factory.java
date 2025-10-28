package entites.interfaces;
import entites.WareHouse;

public interface Factory {

    void addWareHouse(WareHouse wareHouse);
    int getTotalCapacity();
}
