import javafx.collections.ObservableList;

public class OF_list {
    private OrderFalse[] list;
    private static int ID = 1;

        public void record(String n1, int i1, int i2, int i3, int i4, String n2) {
            if (ID == 1)
            {
                list = new OrderFalse[1];
                list[0] = new OrderFalse(n1, i1, i2, i3, i4, n2);
            }
            else{
                OrderFalse[] list2 = new OrderFalse[ID + 1];
                for (int i = 0; i < ID-1; i++)
                    list2[i] = list[i];
                list2[ID-1] = new OrderFalse(n1, i1, i2, i3, i4, n2);
                list = list2;
            }
            ID++;
        }

        public void initData(ObservableList<Order> prData) {
            for (int i = 0; i < ID-1; i++)
                prData.add(new OrderFalse(list[i].getName(), list[i].getID(), list[i].getNum(), list[i].getPrice(), list[i].getSeller(), i, list[i].getReport()));
        }
}

