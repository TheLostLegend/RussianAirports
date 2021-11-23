public class User {
    final String password;
    final String Name;
    public int money;
    public boolean discount;
    public int balance;

    public User(String name, String password) {
        this.Name = name;
        this.password = password;
        this.money = 0;
        this.discount = false;
        this.balance = 0;
    }

    public User(String name, String password, int money, int balance) {
        this.Name = name;
        this.password = password;
        this.money = money;
        this.discount = false;
        this.balance = balance;
    }
    public void setVIP(){
        discount = true;
    }
    public void addB(int i) {balance += i;}
    public boolean buy(int i) {if (i <= balance) {balance-=i; return true;} else return false;}
}
