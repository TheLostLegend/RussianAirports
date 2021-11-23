public class Product
{
    private Integer ID = 0;
    private final String name;
    private Integer InStock;
    private final Integer price;
    private Integer seller;

    public Product(String name, int instock, int price, int seller) {
        this.name = name;
        this.InStock = instock;
        this.price = price;
        this.seller = seller;
    }

    public Product(String name, int instock, int price, int seller, Integer ID) {
        this.name = name;
        this.InStock = instock;
        this.price = price;
        this.seller = seller;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public Integer getInStock(){
        return InStock;
    }
    public void setInStock(Integer i){ this.InStock = i; }
    public Integer getPrice(){ return price; }
    public Integer getSeller(){ return seller; }
    public void setID(Integer ID){ this.ID = ID; }
    public Integer getID(){ return ID; }
}
