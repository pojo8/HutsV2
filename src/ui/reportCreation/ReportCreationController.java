package ui.reportCreation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ReportCreationController {

    @FXML
    private Button order_report;

    @FXML
    private Button order_invoice;

    @FXML
    private Button death_note;

    @FXML
    private Button profit_loss;

    @FXML
    private Button trail_report;

    @FXML
    private Button pay_slip;

    @FXML
    private AnchorPane prof_loss;
    
    @FXML
    protected void openAbout() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../about/About.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("../about.About.fxml"));

        Stage stage = new Stage();

        stage.setTitle("About");

        stage.setScene(new Scene(root, 600, 467));
		//logger.info("Opening About");
        stage.show();
    }
    
    @FXML
    void openOrderReport(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("orderReport/OrderReport.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Order Report");

        stage.setScene(new Scene(root, 630, 420));
        stage.show();

    }

    @FXML
    void openProfLoss(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profAndLoss/ProfAndLoss.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Profit and Loss Report");

        stage.setScene(new Scene(root, 593, 674));
        stage.show();

    }

    @FXML
    void openTrailReport(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("trailReport/TrailReport.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Trail Report");

        stage.setScene(new Scene(root, 593, 674));
        stage.show();

    }
    @FXML
    void openOrderInvoice(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("orderInvoice/OrderInvoice.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Order Invoice");

        stage.setScene(new Scene(root, 593, 674));
        stage.show();

    }
    @FXML
    void openPaySlip(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paySlip/PaySlip.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Order Entry");

        stage.setScene(new Scene(root, 593, 674));
        stage.show();

    }

    @FXML
    void openDeathNote(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("deathNote/DeathNote.fxml"));
        Stage stage = new Stage();

        stage.setTitle("Welcome To Nightmare");

        stage.setScene(new Scene(root, 593, 674));
        stage.show();

    }

}
