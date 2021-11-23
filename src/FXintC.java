import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class FXintC {
    Scene scene;
    Stage stage;
    U_list Users;
    P_list Products;
    O_list Orders;
    O_list OrdersT;
    OF_list OrdersF;

    public void setIntC(U_list Users, P_list Products, O_list Orders, Scene scene, Stage stage, O_list ordersT, OF_list ordersF) {
        this.Users = Users;
        this.Products = Products;
        this.Orders = Orders;
        this.scene = scene;
        this.stage = stage;
        this.OrdersT = ordersT;
        this.OrdersF = ordersF;
    }
    @FXML
    void admin(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXAdmin.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXAdminC intC = loader.getController();
        intC.setADC(Users, this.scene, stage, Products);

    }

    @FXML
    void exit(ActionEvent event) throws SQLException {
        Connection connObj;
        connObj = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-84O8KNE\\SQLEXPRESS:1307;integratedSecurity=true;");
        Statement stmt = (Statement) connObj.createStatement();
        String query1 = "TRUNCATE TABLE SHOP.dbo.USERS";
        stmt.executeUpdate(query1);
        query1 = "TRUNCATE TABLE SHOP.dbo.Products";
        stmt.executeUpdate(query1);
        // the mysql insert statement
        String query = " insert into SHOP.dbo.USERS (UserID, Name, password, money, balance)"  + " values (?, ?, ?, ?, ?)";

        for(int j = 0; j < Users.ID-1; j++) {
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connObj.prepareStatement(query);
            preparedStmt.setInt(1, j);
            preparedStmt.setString(2, Users.getName(j));
            preparedStmt.setString(3, Users.getPass(j));
            preparedStmt.setInt(4, Users.money(j));
            preparedStmt.setInt(5, Users.balCh(j));

            // execute the preparedstatement
            preparedStmt.execute();
            System.out.println("Nice");
        }
        query = " insert into SHOP.dbo.Products (UserID, name, InStock, price)"  + " values (?, ?, ?, ?)";
        for(int j = 0; j < Products.ID-1; j++) {
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt2 = connObj.prepareStatement(query);
            preparedStmt2.setInt(1, Products.getSeller(j)+1);
            preparedStmt2.setString(2, Products.getName(j));
            preparedStmt2.setInt(3, Products.getInStock(j));
            preparedStmt2.setInt(4, Products.cost(j));

            // execute the preparedstatement
            preparedStmt2.execute();
            System.out.println("Nice");
        }
        stage.close();
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXreg.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXregC intC = loader.getController();
        intC.setRegC(Users, this.scene, stage);
    }

    @FXML
    void vhod(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXlogin.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXloginC intC = loader.getController();
        intC.setLoginC(Users, this.scene, stage, Products, Orders, OrdersT, OrdersF);

    }

}
