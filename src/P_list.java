import javafx.collections.ObservableList;

public class P_list implements MList<Product>
{
    private Product[] list;
    public static int ID = 1;

    @Override
    public void record(String n1, int i1, int i2, int i3) {
        if (ID == 1)
        {
            list = new Product[1];
            list[0] = new Product(n1, i1, i2, i3);
        }
        else{
            Product[] list2 = new Product[ID + 1];
            if (ID - 1 >= 0) System.arraycopy(list, 0, list2, 0, ID - 1);
            list2[ID-1] = new Product(n1, i1, i2, i3);
            list = list2;
        }
        ID++;
    }

    @Override
    public Product show_this(int a) {
        return null;
    }

    public boolean ex(int n1, int i2){
        if(list[i2].getInStock() - n1 > 0)
            return true;
        else if(list[i2].getInStock() - n1 == 0)
            return true;
        return false;
    }

    public void ex2(int n1, int i2){
        if(list[i2].getInStock() - n1 > 0) list[i2].setInStock(list[i2].getInStock() - n1);
        else delete(i2);
    }

    public void delete(int i2){
        Product[] list2 = new Product[ID - 1];
        for (int i = 0, j = 0; i < ID-1; i++, j++) {
            if (i == i2) i++;
            if (ID == 2) break;
            list2[j] = list[i];
        }
        list = list2;
        ID = ID -1;

    }

    public int cost(Integer n1)
    {
        return list[n1].getPrice();
    }

    public String getName(int i) {
        return list[i].getName();
    }
    public Integer getInStock(int i){
        return list[i].getInStock();
    }
    public Integer getSeller(int i){ return list[i].getSeller(); }

    public void initData(ObservableList<Product> prData) {
        for (int i = 0; i < ID-1; i++)
        prData.add(new Product(list[i].getName(), list[i].getInStock(), list[i].getPrice(), list[i].getSeller(), i));
    }


    public void initData(ObservableList<Product> prData, int userID) {
        for (int i = 0; i < ID-1; i++)
            if (list[i].getSeller() == userID)
            prData.add(new Product(list[i].getName(), list[i].getInStock(), list[i].getPrice(), list[i].getSeller(), i));
    }
}
