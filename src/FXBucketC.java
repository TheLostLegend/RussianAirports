import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXBucketC extends FXbasic{
    int userID , IDc = 0;
    double i2 = 1;
    P_list Products;
    O_list Orders;
    O_list OrdersT;
    OF_list OrdersF;
    private Boolean Log1 = false, Log2 = false, log3 = false;
    public void setBuckC(U_list Users, Scene scene, Stage stage, int i, P_list Products, O_list Orders, O_list ordersT, OF_list ordersF) {
        this.Products = Products;
        this.Orders = Orders;
        this.Users = Users;
        this.scene = scene;
        this.stage = stage;
        this.userID = i;
        this.OrdersT = ordersT;
        this.OrdersF = ordersF;
        Orders.initData(PrData, userID);

        // устанавливаем тип и значение которое должно хранится в колонке
        IDcolumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
        stColumn1.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Num"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("price"));
        comColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("seller"));

        // заполняем таблицу данными
        Tabl1.setItems(PrData);
    }

    public ObservableList<Order> PrData = FXCollections.observableArrayList();

    @FXML
    private TextField fieldN;

    @FXML
    private Text log1;

    @FXML
    private Text logT;

    @FXML
    private TableView<Order> Tabl1;

    @FXML
    private TableColumn<Order, Integer> IDcolumn;

    @FXML
    private TableColumn<Order, String> nameColumn;

    @FXML
    private TableColumn<Order, Integer> stColumn1;

    @FXML
    private TableColumn<Order, Integer> priceColumn;

    @FXML
    private TableColumn<Order, Integer> comColumn;

    @FXML
    void Add1(ActionEvent event) {
        if (Log2) {
            if (!Users.ex(Orders.getPrice(IDc) ,userID)) logT.setText("Пополните баланс");
            else {
                Users.bal(userID, -1*Orders.getPrice(IDc));
                Users.moneyCh(userID, Orders.getPrice(IDc));
                OrdersT.record(Orders.getName(IDc), userID, Orders.getNum(IDc), Orders.getPrice(IDc), Orders.getSeller(IDc));
                Orders.ex2(IDc);
                logT.setText("Спасибо за покупку!");}
            Tabl1.getItems().clear();

            Orders.initData(PrData, userID);

            // устанавливаем тип и значение которое должно хранится в колонке
            IDcolumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("ID"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
            stColumn1.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Num"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("price"));
            comColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("seller"));

            // заполняем таблицу данными
            Tabl1.setItems(PrData);
        }
        else logT.setText("выберите товар");
    }

    @FXML
    void Add2(ActionEvent event) {
        if (log3 && Log2) {

            OrdersF.record(Orders.getName(IDc), userID, Orders.getNum(IDc), Orders.getPrice(IDc), Orders.getSeller(IDc), name1);
            Products.record(Orders.getName(IDc), Orders.getNum(IDc), Orders.getPrice(IDc) / Orders.getNum(IDc), Orders.getSeller(IDc));
            Orders.ex2(IDc);
            logT.setText("Заказ успешно отменен!");


            Tabl1.getItems().clear();

            Orders.initData(PrData, userID);

            // устанавливаем тип и значение которое должно хранится в колонке
            IDcolumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("ID"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
            stColumn1.setCellValueFactory(new PropertyValueFactory<Order, Integer>("Num"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("price"));
            comColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("seller"));

            // заполняем таблицу данными
            Tabl1.setItems(PrData);
        }
        else logT.setText("выберите товар и введите причину");
    }

    @FXML
    void Numch(KeyEvent event) {
        name1 = fieldN.getText();
        log3 = true;

    }

    @FXML
    void back(ActionEvent event) {
        stage.setScene(this.scene);
        stage.show();
    }

    @FXML
    void initialize() {
        TableView.TableViewSelectionModel<Order> selectionModel = Tabl1.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Order>(){
            @Override
            public void changed(ObservableValue<? extends Order> observableValue, Order order, Order t1) {
                if(t1 != null) {IDc = t1.getID(); Log2 = true;}
                else Log2 = false;
            }
    });
    }

}

