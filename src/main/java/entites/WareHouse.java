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

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(":")
                .append(this.getStock())
                .append("-")
                .append(this.getEmployees());

        return res.toString();
    }

}
