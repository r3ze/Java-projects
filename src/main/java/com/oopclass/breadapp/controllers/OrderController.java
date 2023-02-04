
package com.oopclass.breadapp.controllers;
import com.oopclass.breadapp.config.StageManager;
import com.oopclass.breadapp.models.Orders;
import com.oopclass.breadapp.models.Sales;
import com.oopclass.breadapp.services.impl.OrderService;
import com.oopclass.breadapp.services.impl.SalesService;
import com.oopclass.breadapp.views.FxmlView;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController implements Initializable {
    
     @FXML
    private Button lbl_home;

    @FXML
    private Label lbl_Home;

    @FXML
    private Button btn_salesReport;

    @FXML
    private Label lbl_salesReport;

    @FXML
    private Button btn_salesReport1;

    @FXML
    private Label lbl_salesReport1;

    @FXML
    private Button btn_logOut;

    @FXML
    private Label lbl_logOut;

    @FXML
    private TableView<Orders> orderTable;

    @FXML
    private TableColumn<Orders, String> col_customerName;

    @FXML
    private TableColumn<Orders, String> col_productName;

    @FXML
    private TableColumn<Orders, Double> col_price;

    @FXML
    private TableColumn<Orders, Integer> colQuantity;

    @FXML
    private TableColumn<Orders, Double> colTotalAmount;

    @FXML
    private TableColumn<Orders, String> colAddress;

    @FXML
    private TableColumn<Orders, String> colStatus;
    @FXML
    private TextField txt_quantity;


    @FXML
    private MenuItem deleteProduct11;

    @FXML
    private TextField txt_customer;

    @FXML
    private TextField txt_address;

    @FXML
    private Button btnReset;

    @FXML
    private Button save;

    @FXML
    private TextField txt_product;

    @FXML
    private TextField txt_price;
    
     @FXML
    private TableColumn<Orders, Long> col_id;
      @FXML
    private Label lbl_id;
      
       @Lazy
    @Autowired
    private StageManager stageManager;
     private ObservableList<Orders> order = FXCollections.observableArrayList();
    
     @Autowired
    private SalesService salesService;
    
     
     
     @FXML
    void setAsDelivered(ActionEvent event) {
      
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Set as delivered?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
               Orders orders = orderService.find(Long.parseLong(lbl_id.getText()));
               
        orders.setStatus("delivered");
  
        orderService.update(orders);
         LocalDate currentDate = LocalDate.now();
        Sales sales = new Sales();
        Orders selectedItem = orderTable.getSelectionModel().getSelectedItem();
                    sales.setDate(currentDate);
                    sales.setProductName(col_productName.getCellData(selectedItem));
                    sales.setPrice(Double.parseDouble(col_price.getCellData(selectedItem).toString()));
                    sales.setQuantity(Integer.parseInt(colQuantity.getCellData(selectedItem).toString()));
                    sales.setTotalAmount(Double.parseDouble(colTotalAmount.getCellData(selectedItem).toString()));
                        
                    salesService.save(sales);  
        }

        loadOrderDetails();
    }

    @FXML
    void setText(MouseEvent event) {
 Orders order_id = orderTable.getSelectionModel().getSelectedItem();
 Long id = order_id.getId();

 lbl_id.setText(String.valueOf(id));
    }


    @FXML
    void home_switch(ActionEvent event) {
        stageManager.switchScene(FxmlView.HOME);
    }

    @FXML
    void home_switchScene(MouseEvent event) {
        stageManager.switchScene(FxmlView.HOME);
    }

    @FXML
    void logOut(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);

    }

    @FXML
    void logOut_switch(MouseEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);

    }

    @FXML
    void reset(ActionEvent event) {
        clear();
    }

    @FXML
    void salesReport_switchScene(ActionEvent event) {
        stageManager.switchScene(FxmlView.SALES);

    }

    @FXML
    void salesReport_switchScenes(MouseEvent event) {
        stageManager.switchScene(FxmlView.SALES);

    }
      @FXML
    void products_switch(MouseEvent event) {
        stageManager.switchScene(FxmlView.PRODUCT);
    }
        @FXML
    void products_switchscene(ActionEvent event) {
        stageManager.switchScene(FxmlView.PRODUCT);
    }

     private void setTableProductsColumnProperties() {

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
       col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
       colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colTotalAmount.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
      colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
       colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
       

    }
    private void loadOrderDetails() {
        order.clear();
        order.addAll(orderService.findAll());

        orderTable.setItems(order);
    }
    String Status = "on delivery";
    @Autowired
    private OrderService orderService;
    @FXML
    void save(ActionEvent event) {
        double totalAmount = Double.parseDouble(txt_price.getText()) * Integer.parseInt(txt_quantity.getText());
       Orders order = new Orders();
       order.setCustomerName(txt_customer.getText());
       order.setProductName(txt_product.getText());
       order.setPrice(Double.parseDouble(txt_price.getText()));
       order.setQuantity(Integer.parseInt(txt_quantity.getText()));
       order.setTotalAmount(totalAmount);
       order.setAddress(txt_address.getText());
       order.setStatus(Status);
           orderService.save(order);
           loadOrderDetails();
       clear();
                    

                

    }
    void clear(){
        txt_customer.setText("");
        txt_address.setText("");
        txt_product.setText("");
        txt_price.setText("");
        txt_quantity.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         setTableProductsColumnProperties();
     loadOrderDetails();
    }

}
