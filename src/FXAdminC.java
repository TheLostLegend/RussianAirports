import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXAdminC extends FXbasic{
    int IDc = 0;
    double i2 = 1;
    P_list Products;
    private boolean Log2 = false;
    public void setADC(U_list Users, Scene scene, Stage stage, P_list Products) {
        this.Products = Products;
        this.Users = Users;
        this.scene = scene;
        this.stage = stage;
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
    void Add2(ActionEvent event) {
        if (Log2){
            Products.delete(IDc);
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

    }

    @FXML
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();

    }

    @FXML
    void initialize() {
        TableView.TableViewSelectionModel<Product> selectionModel = Tabl1.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Product>(){
            @Override
            public void changed(ObservableValue<? extends Product> observableValue, Product product, Product t1) {
                if(t1 != null) {IDc = t1.getID(); Log2 = true;}
                else Log2 = false;
            }
        });

    }

}

