public class Order
{
    protected Integer ID = 0;
    protected final String name;
    protected Integer Num;
    protected Integer User;
    protected final Integer price;
    protected Integer seller;

    public Order(String name, int User, int Num, int price, int seller) {
        this.name = name;
        this.Num = Num;
        this.User = User;
        this.price = price;
        this.seller = seller;
    }

    public Order(String name, int User, int Num, int price, int seller, Integer ID) {
        this.name = name;
        this.Num = Num;
        this.User = User;
        this.price = price;
        this.seller = seller;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public Integer getNum(){
        return Num;
    }
    public Integer getPrice(){ return price; }
    public Integer getSeller(){ return seller; }
    public Integer getUser(){ return User;}
    public void setID(Integer ID){ this.ID = ID; }
    public Integer getID(){ return ID; }
}
