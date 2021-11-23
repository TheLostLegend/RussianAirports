import javafx.collections.ObservableList;

public class O_list
{
    private Order[] list;
    private int ID = 1;

    public void record(String n1, int i1, int i2, int i3, int i4) {
        if (ID == 1)
        {
            list = new Order[1];
            list[0] = new Order(n1, i1, i2, i3, i4);
        }
        else{
            Order[] list2 = new Order[ID + 1];
            for (int i = 0; i < ID-1; i++)
                list2[i] = list[i];
            list2[ID-1] = new Order(n1, i1, i2, i3, i4);
            list = list2;
        }
        ID++;
    }

    public void ex2(int i2){
        Order[] list2 = new Order[ID - 1];
            for (int i = 0, j = 0; i < ID-1; i++, j++) {
                if (i == i2) i++;
                if (ID == 2) break;
                list2[j] = list[i];
            }
            list = list2;
            ID = ID -1;

    }


    public String getName(int i) { return list[i].getName(); }
    public Integer getNum(int i){ return list[i].getNum(); }
    public Integer getPrice(Integer n1) { return list[n1].getPrice(); }
    public Integer getSeller(int i){ return list[i].getSeller(); }

    public void initData(ObservableList<Order> prData, int userID) {
        for (int i = 0; i < ID-1; i++)
            if (list[i].getUser() == userID)
            prData.add(new Order(list[i].getName(), list[i].getID(), list[i].getNum(), list[i].getPrice(), list[i].getSeller(), i));
    }

    public void initData(ObservableList<Order> prData) {
        for (int i = 0; i < ID-1; i++)
            prData.add(new Order(list[i].getName(), list[i].getID(), list[i].getNum(), list[i].getPrice(), list[i].getSeller(), i));
    }
}