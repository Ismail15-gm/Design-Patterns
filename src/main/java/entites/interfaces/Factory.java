package entites.interfaces;
import entites.WareHouse;

public interface Factory {
    public void addWareHouse(WareHouse wareHouse);

    int getTotalCapacity();
}
