import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FXUserMC extends  FXbasic{
    int ID = -1;
    Scene scene1;
    P_list Products;
    O_list Orders;
    O_list OrdersT;
    OF_list OrdersF;
    public void setUserMC(U_list Users, Scene scene, Scene scene1, Stage stage, int i, P_list Products, O_list Orders, O_list ordersT, OF_list ordersF) {
        this.Products = Products;
        this.Orders = Orders;
        this.Users = Users;
        this.scene = scene;
        this.scene1 = scene1;
        this.stage = stage;
        this.ID = i;
        this.OrdersT = ordersT;
        this.OrdersF = ordersF;
    }

    @FXML
    private Text log1;

    @FXML
    void Basket(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXbucket.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXBucketC intC = loader.getController();
        intC.setBuckC(Users, this.scene1, stage, ID, Products, Orders, OrdersT, OrdersF);
    }

    @FXML
    void MakeOrder(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXOrder.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXOrderC intC = loader.getController();
        intC.setOrdC(Users, this.scene1, stage, ID, Products, Orders);
    }

    @FXML
    void MyCompany(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXCompany.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXCompanyC intC = loader.getController();
        intC.setComC(Users, this.scene1, stage, ID, Products);

    }

    @FXML
    void Status(ActionEvent event) {int bal = Users.balCh(ID);
        if (Users.vipcheck(ID)) log1.setText("Balance: " + bal + "\nHello VIP User!");
        else log1.setText("Balance: " + bal + "\nVIP progress:" + Users.money(ID) + "/5000");
    }

    @FXML @Override
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();
    }

    @FXML
    void balance(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MAINDOOR.class.getResource("FXBalance.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXBalanceC intC = loader.getController();
        intC.setBalC(Users, this.scene1, stage, ID);
    }

}

