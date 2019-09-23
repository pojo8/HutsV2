package ui.mainMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class MainMenuController  {
	
	private static Logger logger =  (Logger) LogManager.getLogger(MainMenuController.class);

	
    public MainMenuController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        fxmlLoader.setController(this);
    }
    
    @FXML
    protected void openAbout() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../about/About.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("../about.About.fxml"));

        Stage stage = new Stage();

        stage.setTitle("About");

        stage.setScene(new Scene(root, 600, 467));
		logger.info("Opening About");
        stage.show();
    }
    
    @FXML
    protected void openHelp() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../orderProcessing/OrderProcessing.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Help I can't breathe");

        stage.setScene(new Scene(root, 564, 398));
		logger.info("Opening Orders Processing");
        stage.show();
    }

    @FXML
    protected void openOrders() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../orderManagement/OrderManagement.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Order Entry");

        stage.setScene(new Scene(root, 593, 674));
		logger.info("Opening Orders Management");
        stage.show();
    }

    @FXML
    protected void openReports() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../reportCreation/ReportCreation.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Order Entry");

        stage.setScene(new Scene(root, 600, 400));
		logger.info("Opening reporting");

        stage.show();
    }
    
    @FXML
    protected void openOrderProcessing() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../orderProcessing/OrderProcessing.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Order Processing");

        stage.setScene(new Scene(root, 564, 398));
		logger.info("Opening Orders Processing");
        stage.show();
    }
    
    @FXML
    protected void openNotification() throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("OrderManagement.fxml"));
//        Stage stage = new Stage();
//
//        stage.setTitle("Order Entry");
//
//        stage.setScene(new Scene(root, 787, 446));
//        stage.show();
        System.out.println("hello");
    }
}
