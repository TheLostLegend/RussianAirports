import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Scanner;


public class MAINDOOR extends Application {
    Connection Cnn;
    Scanner in = new Scanner(System.in);
    U_list Users = new U_list();
    P_list Products = new P_list();
    O_list Orders = new O_list();
    O_list OrdersT = new O_list();
    OF_list OrdersF = new OF_list();
    String name1 = "345", name2 = "123", name3 = "234", i2;
    int ID, i, i3;
    boolean ps, im;

    static  void main (String [] args){
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        int i10 = 0;
        try {
        Connection connObj;
        connObj = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-84O8KNE\\SQLEXPRESS:1307;integratedSecurity=true;");

        Statement stmtObj = connObj.createStatement();
        ResultSet resObj = stmtObj.executeQuery("SELECT UserID, Name, password, money, balance FROM SHOP.dbo.USERS;");
        while (resObj.next()) {
            Users.record(resObj.getString("Name"), resObj.getString("password"), resObj.getInt("money"), resObj.getInt("balance"));
            Users.moneyCh(i10, 0);
            System.out.println("Nice");
            i10++;
        }
        resObj = stmtObj.executeQuery("SELECT UserID, Name, InStock, price FROM SHOP.dbo.Products;");
        while (resObj.next()) {
            Products.record(resObj.getString("Name"), resObj.getInt("InStock"), resObj.getInt("price"), resObj.getInt("UserID"));
            System.out.println("Nice");
        }
        }
        catch (SQLException e) {System.out.println("Fuck");}
        im = true;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXint.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXintC intC = loader.getController();
        intC.setIntC(Users, Products, Orders, scene, stage, OrdersT, OrdersF);
    }
}
