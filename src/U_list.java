public class U_list
{
    private User[] list;
    public static int ID = 1;

    public void record(String n1, String n2) {
        if (ID == 1)
        {
            list = new User[1];
            list[0] = new User(n1, n2);
        }
        else{
            User[] max2 = new User[ID + 1];
            for (int i = 0; i < ID-1; i++)
                max2[i] = list[i];
            max2[ID-1] = new User(n1, n2);
            list = max2;
        }
        ID++;
    }

    public void record(String n1, String n2, int n3, int n4) {
        if (ID == 1)
        {
            list = new User[1];
            list[0] = new User(n1, n2, n3, n4);
        }
        else{
            User[] max2 = new User[ID + 1];
            for (int i = 0; i < ID-1; i++)
                max2[i] = list[i];
            max2[ID-1] = new User(n1, n2, n3, n4);
            list = max2;
        }
        ID++;
    }
    public int login(String n1){
        for (int i = 0; i < ID - 1; i++)
            if (list[i].Name.equals(n1))
                return i;
        return -1;
    }
    public boolean passw(String n1, int i){
        return list[i].password.equals(n1);
    }
    public int money(int ID) {return list[ID].money; }


    public boolean ex(int n1, int i2){
        if(list[i2].balance - n1 > 0)
            return true;
        else if(list[i2].balance - n1 == 0)
            return true;
        return false;
    }
    public boolean vipcheck(int ID)
    {
        return list[ID].discount;
    }
    public String getName(int ID) {return list[ID].Name;}
    public String getPass(int ID) {return list[ID].password;}
    public int balCh(int ID) {return list[ID].balance;}
    public void moneyCh(int ID, int money) {list[ID].money = list[ID].money + money; if(list[ID].money >= 5000) setV(ID);}
    public void setV(int ID) {list[ID].setVIP();}
    public void bal(int ID, int bal1) {list[ID].addB(bal1);}
}

