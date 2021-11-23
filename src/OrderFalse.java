public class OrderFalse extends Order {
    private String report;

    public OrderFalse(String name, int User, int Num, int price, int seller, String report) {
        super(name, User, Num, price, seller);
        this.report = report;
    }

    public OrderFalse(String name, int User, int Num, int price, int seller, Integer ID, String report) {
        super(name, User, Num, price, seller, ID);
        this.report = report;
    }
    public String getReport() {
        return report;
    }
}
