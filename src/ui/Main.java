package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main extends Application {
	
	private static Logger logger =  (Logger) LogManager.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu/MainMenu.fxml"));
        primaryStage.setTitle("Main menu");

        primaryStage.setScene(new Scene(root, 787, 446));
        primaryStage.show();
    }




    public static void main(String[] args) {
		logger.info("Application launched...");
        launch(args);
    }
}
