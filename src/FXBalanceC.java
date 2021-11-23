import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXBalanceC extends FXbasic{
    int ID;
    int balance = 0;
    private boolean Log1 = false;
    public void setBalC(U_list Users, Scene scene, Stage stage, int i) {
        this.Users = Users;
        this.scene = scene;
        this.stage = stage;
        this.ID = i;
    }

    @FXML
    private TextField fieldN;

    @FXML
    private Text log1;

    @FXML
    void Add1(ActionEvent event) {
        if (Log1) {Users.bal(ID, balance); log1.setText("Успешно");}
        else log1.setText("Введите число для пополнения");
    }

    @FXML @Override
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();
    }

    @FXML
    void keyT(KeyEvent event) {
        name1 = fieldN.getText();
        try { balance = Integer.parseInt(name1); Log1 = true; }
        catch (NumberFormatException e) { Log1 = false; }
    }

}

