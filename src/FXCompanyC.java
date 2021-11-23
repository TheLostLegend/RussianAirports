import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXCompanyC extends FXbasic{
    int userID , IDc = 0, i1=0, i2=0;
    P_list Products;
    private Boolean Log1 = false, Log2 = false, Log3 = false;
    public void setComC(U_list Users, Scene scene, Stage stage, int i, P_list Products) {
        this.Products = Products;
        this.Users = Users;
        this.scene = scene;
        this.stage = stage;
        this.userID = i;
        Products.initData(PrData, userID);

        // устанавливаем тип и значение которое должно хранится в колонке
        IDcolumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        stColumn1.setCellValueFactory(new PropertyValueFactory<Product, Integer>("InStock"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        comColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("seller"));

        // заполняем таблицу данными
        Tabl1.setItems(PrData);
    }

    public ObservableList<Product> PrData = FXCollections.observableArrayList();

    @FXML
    private TextField fieldN12;

    @FXML
    private Text log1;

    @FXML
    private Text logT;

    @FXML
    private TableView<Product> Tabl1;

    @FXML
    private TableColumn<Product, Integer> IDcolumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, Integer> stColumn1;

    @FXML
    private TableColumn<Product, Integer> priceColumn;

    @FXML
    private TableColumn<Product, Integer> comColumn;

    @FXML
    private TextField fieldN1;

    @FXML
    private TextField fieldN2;

    @FXML
    private Text log11;

    @FXML
    private Text log111;

    @FXML
    void Add2(ActionEvent event) {
    if(Log1&&Log2&&Log3) {Products.record(name1, i1, i2, userID);
        logT.setText("Товар был добавлен!");
        Tabl1.getItems().clear();
        Products.initData(PrData, userID);

        // устанавливаем тип и значение которое должно хранится в колонке
        IDcolumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        stColumn1.setCellValueFactory(new PropertyValueFactory<Product, Integer>("InStock"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        comColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("seller"));
        // заполняем таблицу данными
        Tabl1.setItems(PrData);
    }
    else logT.setText("Заполните все поля!");
    }

    @FXML
    void Numch(KeyEvent event) {
        name2 = fieldN1.getText();
        try { i1 = Integer.parseInt(name2); Log2 = true; }
        catch (NumberFormatException e) { Log2 = false; }

    }

    @FXML
    void Numch0(KeyEvent event) {
        name1 = fieldN12.getText();
        Log1 = true;
    }

    @FXML
    void Numch1(KeyEvent event) {
        name2 = fieldN2.getText();
        try { i2 = Integer.parseInt(name2); Log3 = true; }
        catch (NumberFormatException e) { Log3 = false; }

    }

    @FXML
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();
    }

    public void initialize() {
    }
}