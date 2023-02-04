
package com.oopclass.breadapp.controllers;

import com.oopclass.breadapp.config.StageManager;
import com.oopclass.breadapp.models.Product;
import com.oopclass.breadapp.services.impl.ProductService;
import com.oopclass.breadapp.views.FxmlView;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;


@Controller
public class ProductController implements Initializable {
    
        @FXML
    private TextField txt_search;
      @FXML
    private Button btn_home;

   @FXML
    private Button lbl_home;

    
    @FXML
    private Button btn_salesReport;

    @FXML
    private Label lbl_salesReport;
     @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, Long> colID;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Double> colPrice;

    @FXML
    private Button btn_newProduct;
    
     @FXML
    private TableColumn<Product, Boolean> colEdit;

    @FXML
    private TextField productName;

    @FXML
    private TextField price;

    @FXML
    private Button btnReset;
    
    @FXML
    private Label product_id;


    @FXML
    private Button saveProduct;

    @Autowired
    private ProductService productService;
      
      
    @Lazy
    @Autowired  
    private StageManager stageManager;
    
    private ObservableList<Product> productList = FXCollections.observableArrayList();
        private void setTableProductsColumnProperties() {


        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colEdit.setCellFactory(cellFactory);
        
    }
         private void loadProductDetails() {
        productList.clear();
        productList.addAll(productService.findAll());

        productTable.setItems(productList);
    }
         //edit products
  Callback<TableColumn<Product, Boolean>, TableCell<Product, Boolean>> cellFactory
            = new Callback<TableColumn<Product, Boolean>, TableCell<Product, Boolean>>() {
        @Override
        public TableCell<Product, Boolean> call(final TableColumn<Product, Boolean> param) {
            final TableCell<Product, Boolean> cell = new TableCell<Product, Boolean>() {
                Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
                final Button btnEdit = new Button();

                @Override
                public void updateItem(Boolean check, boolean empty) {
                    super.updateItem(check, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btnEdit.setOnAction(e -> {
                            Product product = getTableView().getItems().get(getIndex());
                            updateUser(product);
                        });

                        btnEdit.setStyle("-fx-background-color: transparent;");
                        ImageView iv = new ImageView();
                        iv.setImage(imgEdit);
                        iv.setPreserveRatio(true);
                        iv.setSmooth(true);
                        iv.setCache(true);
                        btnEdit.setGraphic(iv);

                        setGraphic(btnEdit);
                        setAlignment(Pos.CENTER);
                        setText(null);
                    }
                }

                private void updateUser(Product product) {
                     product_id.setText(Long.toString(product.getId()));
                    productName.setText(product.getProductName());
                    price.setText(String.valueOf(product.getPrice()));
                }
            };
            return cell;
        }
    };
  // add product
  @FXML
    void saveProduct(ActionEvent event) {
        if (product_id.getText() == null || "".equals(product_id.getText())) {
                if (true) {

                    Product product = new Product();
                    product.setProductName(productName.getText());
                    product.setPrice(Double.parseDouble(price.getText()));
                    

                    Product newProduct = productService.save(product);
                }

            } else {
                Product product = productService.find(Long.parseLong(product_id.getText()));
                product.setProductName(productName.getText());
                product.setPrice(Double.parseDouble(price.getText()));
            
                Product updatedProduct = productService.update(product);
                
            }

             loadProductDetails(); 
             clearFields();
    }
    //delete product
        @FXML
    void deleteProduct(ActionEvent event) {
List<Product> product = productTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            productService.deleteInBatch(product);
        }

        loadProductDetails();
    }
            private void clearFields() {
        product_id.setText(null);
        productName.clear();
        price.clear();
      
    }
            // search products
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
    void reset(ActionEvent event) {
        clearFields();
    }
    
    //switch scenes
      @FXML
    void home_switchScene(MouseEvent event) {
stageManager.switchScene(FxmlView.HOME);
    }
    @FXML
    void home_switch(ActionEvent event) {
stageManager.switchScene(FxmlView.HOME);
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
    void orders_switchScene(ActionEvent event) {
        stageManager.switchScene(FxmlView.ORDERS);
    }

    @FXML
    void orders_switchScenes(MouseEvent event) {
        stageManager.switchScene(FxmlView.ORDERS);

    }
        @FXML
    void logOut(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @FXML
    void logOut_switch(MouseEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);

    }

            
          
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 productTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setTableProductsColumnProperties();
       

        // Add all users into table
        loadProductDetails(); 
    }
    


    

}
