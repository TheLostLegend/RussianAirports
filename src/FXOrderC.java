import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.web.PromptData;
import javafx.stage.Stage;

public class FXOrderC extends FXbasic{
    int userID , IDc = 0;
    double i2 = 1;
    P_list Products;
    O_list Orders;
    private Boolean Log1 = false, Log2 = false, ps = false;
    public void setOrdC(U_list Users, Scene scene, Stage stage, int i, P_list Products, O_list Orders) {
        this.Products = Products;
        this.Orders = Orders;
        this.Users = Users;
        this.scene = scene;
        this.stage = stage;
        this.userID = i;
        Products.initData(PrData);

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
    private TextField fieldN;

    @FXML
    private Text logT;

    @FXML
    private void initialize() {
        TableView.TableViewSelectionModel<Product> selectionModel = Tabl1.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Product>(){
            @Override
            public void changed(ObservableValue<? extends Product> observableValue, Product product, Product t1) {
                if(t1 != null) {IDc = t1.getID(); Log2 = true;}
                else Log2 = false;
            }
        });
    }

    @FXML
    private Text log1;

    @FXML
    void Numch(KeyEvent event) {
        name1 = fieldN.getText();
        try { i = Integer.parseInt(name1); Log1 = true; }
        catch (NumberFormatException e) { Log1 = false; }

    }

    @FXML
    void Add1(ActionEvent event) {
        if (Log1 && Log2) {
            if (!Products.ex(i ,IDc)) logT.setText("столько нет в наличии");
            else {
                if (Users.vipcheck(userID)) i2 = 0.90;
                else i2 = 1;
                Orders.record(Products.getName(IDc), userID, i, (int) (i2*i*Products.cost(IDc)), Products.getSeller(IDc));
                Products.ex2(i, IDc);
                logT.setText("заказ добавлен, проверьте корзину.");}
            Tabl1.getItems().clear();
            Products.initData(PrData);

            // устанавливаем тип и значение которое должно хранится в колонке
            IDcolumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("ID"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
            stColumn1.setCellValueFactory(new PropertyValueFactory<Product, Integer>("InStock"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
            comColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("seller"));
            // заполняем таблицу данными
            Tabl1.setItems(PrData);
        }
        else logT.setText("выберите товар и введите кол-во");
    }

    @FXML
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();
    }

}
