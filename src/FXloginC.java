import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FXloginC extends  FXbasic{
    P_list Products;
    O_list Orders;
    O_list OrdersT;
    OF_list OrdersF;
    public void setLoginC(U_list Users, Scene scene, Stage stage, P_list Products, O_list Orders, O_list ordersT, OF_list ordersF) {
        this.Products = Products;
        this.Orders = Orders;
        this.Users = Users;
        this.scene = scene;
        this.stage = stage;
        this.OrdersT = ordersT;
        this.OrdersF = ordersF;
    }

    private Boolean Log1 = false, Log2 = false, ps = false;

    @FXML
    private TextField logW;


    @FXML
    private PasswordField PasW1;

    @FXML
    private Text RegFinal;

    @FXML @Override
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();
    }

    @FXML
    void loginScan(KeyEvent event) {
        name1 = logW.getText();
        i = Users.login(name1);
        if (i == -1) { Log1 = false;}
        else {Log1 = true;}
    }

    @FXML
    void passw1Scan(KeyEvent event) {
        name2 = PasW1.getText();
        ps = Users.passw(name2, i);
        if (!ps) { Log2 = false;}
        else {Log2 = true;}

    }

    @FXML
    void loginMain(ActionEvent event) throws IOException {
        if (Log1 && Log2) {
            RegFinal.setText("Вход успешен, перенаправление.");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MAINDOOR.class.getResource("FXUserM.fxml"));
            AnchorPane root = loader.load();
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
            FXUserMC intC = loader.getController();
            intC.setUserMC(Users, this.scene, scene1, stage, i, Products, Orders, OrdersT, OrdersF);
        }
        else RegFinal.setText("Введен неверный логин или пароль");
    }

}
