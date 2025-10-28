package entites;

public class WareHouse {
        String totalEmployees;
    String stock;

    public WareHouse(String stock , String totalEmployees){
        this.totalEmployees = totalEmployees;
        this.stock = stock;
    }

    public String getStock() {
        return stock;
    }

    public String getEmployees() {
        return totalEmployees;
    }
}
