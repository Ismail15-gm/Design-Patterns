package entites;

public class WareHouse {
    String employees_number;
    String stock;

    public WareHouse(String employees_number, String stock){
        this.employees_number = employees_number;
        this.stock = stock;
    }

    public String getStock() {
        return stock;
    }

    public String getEmployees() {
        return employees_number;
    }
}
