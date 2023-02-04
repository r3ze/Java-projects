
package com.oopclass.breadapp.controllers;
import java.util.Date;
import com.oopclass.breadapp.config.StageManager;
import com.oopclass.breadapp.models.Product;
import com.oopclass.breadapp.models.ProductList;
import com.oopclass.breadapp.models.Sales;
import com.oopclass.breadapp.services.impl.SalesService;
import com.oopclass.breadapp.views.FxmlView;
import java.net.URL;

import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class SalesController implements Initializable{
     @FXML
    private Button lbl_home;

    @FXML
    private Label lbl_Home;

    @FXML
    private Button btn_products;

    @FXML
    private Label lbl_products;

    @FXML
    private TableView<Sales> salesTable;

    @FXML
    private TableColumn<Sales, LocalDate> colDate;

    @FXML
    private TableColumn<Sales, String> colProductName;

    @FXML
    private TableColumn<Sales, Double> colPrice;

    @FXML
    private TableColumn<Sales, Integer> colQuantity;
    
     @FXML
    private Label lbl_totalSales;
     
     @FXML
    private Button btn_filter;

    @FXML
    private DatePicker datepicker1;


    @FXML
    private DatePicker datepicker2;


    @FXML
    private TableColumn<Sales, Double> colSubtotal;
    @Autowired
    private SalesService salesService;
     private ObservableList<Sales> sales = FXCollections.observableArrayList();
     
      @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML

        private void loadSalestDetails() {
        sales.clear();
       sales.addAll(salesService.findAll());

        salesTable.setItems(sales);
                
    }
    // set total sales    
    private void setTotalSales(){
         double totalSales = 0;
                 for(Sales list:salesTable.getItems()){
 Sales sales = new Sales();
                    sales.setTotalAmount(Double.parseDouble(colSubtotal.getCellData(list).toString()));
                    totalSales+=sales.getTotalAmount();
                        
 }
                         lbl_totalSales.setText(String.valueOf(totalSales));
    }

      private void setSalesColumnProperties() {
                                                                
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colSubtotal.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        

    }
      // filter data in table view
          @FXML
    void filter(ActionEvent event) {
          LocalDate startDate = datepicker1.getValue();
        LocalDate endDate = datepicker2.getValue();

        // Retrieve all the data from the repository
        List<Sales> allData = salesService.findAll();

        // Filter the data in memory using the values of the DatePicker controls
        List<Sales> filteredData = allData.stream()
            .filter(d -> d.getDate().isAfter(startDate) && d.getDate().isBefore(endDate))
            .collect(Collectors.toList());

        // Update the items in the TableView with the filtered data
        salesTable.getItems().setAll(filteredData);
         setTotalSales();
    }
    // show all sales
    @FXML
    void viewAll(ActionEvent event) {
loadSalestDetails();
       setSalesColumnProperties();
        setTotalSales();
    }


    
    //swtich scenes
    @FXML
        void home_switch(ActionEvent event) {
        stageManager.switchScene(FxmlView.HOME);
    }

    @FXML
    void home_switchScene(MouseEvent event) {
 stageManager.switchScene(FxmlView.HOME);
    }

    @FXML
    void products_switch(ActionEvent event) {
 stageManager.switchScene(FxmlView.PRODUCT);
    }

    @FXML
    void products_switchScene(MouseEvent event) {
 stageManager.switchScene(FxmlView.PRODUCT);
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


       loadSalestDetails();
       setSalesColumnProperties();
       setTotalSales();
    }
    
    
}
