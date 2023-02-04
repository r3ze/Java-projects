
package com.oopclass.breadapp.controllers;
import java.util.List;
import javafx.scene.control.ButtonType;
import com.oopclass.breadapp.config.StageManager;
import com.oopclass.breadapp.models.Product;
import com.oopclass.breadapp.models.ProductList;
import com.oopclass.breadapp.models.Sales;
import com.oopclass.breadapp.services.impl.ProductService;
import com.oopclass.breadapp.services.impl.SalesService;
import com.oopclass.breadapp.views.FxmlView;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javafx.util.Duration.millis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

@Controller
public class HomeController implements Initializable{
    
    public double price = 0;
    double totalAmount = 0;
    @FXML
    private TableView<Product> productTable;
     @FXML
     
    private TableView<ProductList> listTable;
     
      @FXML
    private TextField txt_search;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Double> colPrice;
    
        @FXML
    private TableColumn<Product, Long> colID;

    @FXML
    private TextField txt_amountTendered;

    @FXML
    private Button btn_pay; 
    
    @FXML
    private TextField txt_Quantity;
    
    @FXML
    private Label lbl_productName;

    @FXML
    private Label txt_totalAmount;
    
    
    @FXML
    private Label lblPrice;


    @FXML
    private Label lbl_change;
    @FXML
    private Button btn_productList;

    @FXML
    private Label productSwitch;

    @FXML
    private Button btn_salesReport;

    @FXML
    private Label lbl_salesReport;

    
       @FXML
    private TableColumn<ProductList, String> colName1;

    @FXML
    private TableColumn<ProductList, Double> colPrice1;

    @FXML
    private TableColumn<ProductList, Integer> colQuantity;

    @FXML
    private TableColumn<ProductList, Double> colTotalPrice;
    
    @FXML
    private DatePicker datePicker;

    @FXML
    private Label txt_totalAmount1;

    @FXML
    private Button btnPay;
    
    @FXML
    private Button btn_logOut;

    @FXML
    private Label lbl_logOut;
    
     @Lazy
    @Autowired
    private StageManager stageManager;
    

     private ObservableList<Product> productList = FXCollections.observableArrayList();
   
      private ObservableList<Sales> Sales = FXCollections.observableArrayList();
      
   
     
    @Autowired
    private ProductService productService;
    @Autowired
    private SalesService salesService;
    
        private void setTableProductsColumnProperties() {


        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
         private void setListProductsColumnProperties() {
        colName1.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colPrice1.setCellValueFactory(new PropertyValueFactory<>("price"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

    }
        
    
    private void loadProductDetails() {
        productList.clear();
        productList.addAll(productService.findAll());

        productTable.setItems(productList);
    }
    
@FXML //set product name text
    void setText(MouseEvent event) {
      int rowIndex = productTable.getSelectionModel().getSelectedIndex();
clear();
       Product product = productTable.getSelectionModel().getSelectedItem();
       String productName = product.getProductName();
       Double productPrice = product.getPrice();
        lbl_productName.setText(productName);
        lblPrice.setText(String.valueOf(productPrice));

      
    }
     @FXML
    void setToInt(KeyEvent event) {
          
    }
    
  
        @FXML
    void setTotalAmount(KeyEvent event) {
        
        if(txt_Quantity.getText().equals("")){
            txt_totalAmount.setText("0.00");
        }
  double value = Double.parseDouble(txt_Quantity.getText()) * Double.parseDouble(lblPrice.getText());
        txt_totalAmount.setText(String.valueOf(value));
        
    }
    
    private ObservableList<ProductList> List = FXCollections.observableArrayList();
    @FXML
    void add(ActionEvent event) { 
        if(lbl_productName.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error.");
        alert.setHeaderText(null);
        alert.setContentText("Please select a product " );
         alert.showAndWait();
        }
        else if(txt_Quantity.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error.");
        alert.setHeaderText(null);
        alert.setContentText("Please enter quantity " );
         alert.showAndWait();
        }
         else if(txt_Quantity.getText().equals("")&&lbl_productName.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error.");
        alert.setHeaderText(null);
        alert.setContentText("Please select a product and enter quantity " );
         alert.showAndWait();
        }
        else{ //add product to list of products table
               totalAmount+=Double.parseDouble(txt_totalAmount.getText());
ProductList newItem = new ProductList(lbl_productName.getText(), Double.parseDouble(lblPrice.getText()), Integer.parseInt(txt_Quantity.getText()), Double.parseDouble(txt_totalAmount.getText()));
      List = listTable.getItems();
List.add(newItem);
listTable.setItems(List);
txt_totalAmount1.setText(String.valueOf(totalAmount));

                     
clear();
        }

    }
    
    
    
        @FXML
    void setChange(KeyEvent event) {
        if(txt_amountTendered.getText().equals("")){
            lbl_change.setText("0.00");
        }
        double change = Double.parseDouble(txt_amountTendered.getText()) - Double.parseDouble(txt_totalAmount1.getText());
        lbl_change.setText(String.valueOf(change));
    }
    void clear(){
        lbl_productName.setText("");
        lblPrice.setText("");
        txt_Quantity.setText("");
        txt_totalAmount.setText("0.00");
        
    } 
 
    @FXML
    void pay(ActionEvent event) throws IOException {
    
 
 if(txt_totalAmount1.getText().equals("0.0")){
     Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error.");
        alert.setHeaderText(null);
        alert.setContentText("List of orders is empty." );
         alert.showAndWait();
 }
 else if(txt_amountTendered.getText().equals("")){
     Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error.");
        alert.setHeaderText(null);
        alert.setContentText("Please enter an amount." );
         alert.showAndWait();
 }
 else{
     if(totalAmount<=Double.parseDouble(txt_amountTendered.getText())){
              //add product to sales database
 for(ProductList list:listTable.getItems()){
      LocalDate currentDate = LocalDate.now();
 Sales sales = new Sales();

                    sales.setDate(currentDate);
                    sales.setProductName(colName1.getCellData(list));
                    sales.setPrice(Double.parseDouble(colPrice1.getCellData(list).toString()));
                    sales.setQuantity(Integer.parseInt(colQuantity.getCellData(list).toString()));
                    sales.setTotalAmount(Double.parseDouble(colTotalPrice.getCellData(list).toString()));
                        
                    Sales newSales = salesService.save(sales);  
 }
 
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information.");
        alert.setHeaderText(null);
        alert.setContentText("Payment successful " );
         alert.showAndWait();
         
         
 List.clear();
txt_totalAmount1.setText("0.0");
txt_amountTendered.setText("");
lbl_change.setText("");
     }
     else{
          Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error.");
        alert.setHeaderText(null);
        alert.setContentText("Insufficient amount tendered." );
         alert.showAndWait();
     }

 }
 

    }
   
                    
                 
    
      @FXML
    void deleteProduct(ActionEvent event) {
List<ProductList> product = listTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();
        ProductList list = listTable.getSelectionModel().getSelectedItem();
        if (action.get() == ButtonType.OK) {
          ObservableList<ProductList> selectedItems = listTable.getSelectionModel().getSelectedItems();
          Double ta = list.getTotalPrice();
        totalAmount -=ta;
        txt_totalAmount1.setText(String.valueOf(totalAmount));
          List.removeAll(selectedItems);
           
                    }

    
    }


            @FXML
    void search(KeyEvent event) {
        if(txt_search.getText().equals("")){
            setTableProductsColumnProperties();
            loadProductDetails();
        }
        else{
              
              String searchText = txt_search.getText().toLowerCase();
                         
              
    // Use a Predicate to filter the data in the table view
    Predicate<Product> filter = obj -> obj.getProductName().toLowerCase().contains(searchText);
    FilteredList<Product> filteredData = new FilteredList<>(productTable.getItems(), filter);
    productTable.setItems(filteredData);
        }

    }
    
        @FXML
    void productSwitchScene(MouseEvent event) {
       
        stageManager.switchScene(FxmlView.PRODUCT);
        totalAmount = 0;
    }   
    
    @FXML
    void productList_switchScene(ActionEvent event) {
 stageManager.switchScene(FxmlView.PRODUCT);
 totalAmount = 0;
    }

    @FXML
    void salesReport_switchScene(ActionEvent event) {
        stageManager.switchScene(FxmlView.SALES);
        totalAmount = 0;

    }

    @FXML
    void salesReport_switchScenes(MouseEvent event) {
        stageManager.switchScene(FxmlView.SALES);
        totalAmount = 0;

    }
    @FXML
    void orders_switchScene(ActionEvent event) {
        stageManager.switchScene(FxmlView.ORDERS);
    }

    @FXML
    void orders_switchScenes(MouseEvent event) {
        stageManager.switchScene(FxmlView.ORDERS);

    }
    
        @FXML
    void logOut(MouseEvent event) {
 stageManager.switchScene(FxmlView.LOGIN);
 totalAmount = 0;
    }
        @FXML
    void switch_logOut(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
        totalAmount = 0;

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
     productTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setTableProductsColumnProperties();
        setListProductsColumnProperties();

        // Add all users into table
        loadProductDetails(); 
        

    }

    
}
