
package com.oopclass.breadapp.controllers;

import com.oopclass.breadapp.config.StageManager;
import com.oopclass.breadapp.views.FxmlView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class LogInController implements Initializable{
    
    
    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private TextField txt_userName;

    @FXML
    private PasswordField txt_password;
    
    @FXML
    private Label lbl_error;


    
     @FXML
    void login(ActionEvent event) {
        Stage stage = new Stage();
        
        if(txt_userName.getText().equals("admin")&&txt_password.getText().equals("123")){
            stage.setFullScreen(true);
            stageManager.switchScene(FxmlView.HOME);
        }
        else{
             Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error.");
        alert.setHeaderText(null);
        alert.setContentText("Wrong username or password." );
         alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    

}