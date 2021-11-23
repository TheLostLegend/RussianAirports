import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXregC extends  FXbasic{

    public void setRegC(U_list Users, Scene scene, Stage stage) {

        this.Users = Users;
        this.scene = scene;
        this.stage = stage;
    }
    String name3;
    private Boolean Reg1 = false, Reg2 = false, Reg3 = false;
    @FXML
    private Text log1;

    @FXML
    private Text passw1;

    @FXML
    private Text passw2;

    @FXML
    private Text RegFinal;

    @FXML
    private TextField logW;

    @FXML
    private PasswordField PasW1;

    @FXML
    private PasswordField PasW2;

    @FXML
    void loginScan(KeyEvent event) {
        name1 = logW.getText();
        i = Users.login(name1);
        if (name1.equals("Admin")) {log1.setText("Большой брат следит за тобой и не допустит этого"); Reg1 = false;}
        else if (name1.length() < 8) {log1.setText("Логин слишком короткий"); Reg1 = false;}
        else if (name1.length() > 12) {log1.setText("Логин слишком длинный"); Reg1 = false;}
        else if (i!=-1) {log1.setText("Логин занят"); Reg1 = false;}
        else {log1.setText("Вы можете исспользовать этот логин"); Reg1 = true;}
    }

    @FXML
    void passw1Scan(KeyEvent event) {
        name3 = PasW1.getText();
        if (name3.length() < 8) {passw1.setText("Пароль слишком короткий"); Reg2 = false;}
        else if (name3.length() > 12) {passw1.setText("Пароль слишком длинный"); Reg2 = false;}
        else {passw1.setText("Вы можете исспользовать этот пароль"); Reg2 = true;}
    }

    @FXML
    void passw2Scan(KeyEvent event) {
        name2 = PasW2.getText();
        if (!name2.equals(name3)) {passw2.setText("Пароли не совпадают"); Reg3 = false;}
        else {passw2.setText("Пароли совпали"); Reg3 = true;}
    }

    public void registerMain(ActionEvent actionEvent) {
        if (Reg1 && Reg2 && Reg3) {Users.record(name1, name2); RegFinal.setText("Регистрация успешна! Войдите в свой аккаунт через главное меню.");}
        else RegFinal.setText("Регистрация отклонена");
    }


    @FXML @Override
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();
    }
}