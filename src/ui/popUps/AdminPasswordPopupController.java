package ui.popUps;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.orderProcessing.OrderProcessingController;

public class AdminPasswordPopupController {

    @FXML private Button loginButton;

    @FXML
    private AnchorPane anchorPane;
    
    @FXML private TextField userField;
    @FXML private PasswordField passwordField;
    
    @FXML
    void login(ActionEvent event) throws NumberFormatException, IOException, SQLException {
    	System.out.println(passwordField.getText());
    	if(userField.getText().equals("admin") && passwordField.getText().equals("admin")) {
    		System.out.println("Validated");
    		Stage stage = (Stage) loginButton.getScene().getWindow();
    		stage.close();
    		OrderProcessingController.hasAdminPermissions = true;
    		
    	} else {
    		Stage stage = (Stage) loginButton.getScene().getWindow();
    		stage.show();
    	}
    }

}
