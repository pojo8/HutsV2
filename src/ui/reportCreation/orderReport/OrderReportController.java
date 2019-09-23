package ui.reportCreation.orderReport;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import ui.tableView.OrderRepTable;


public class OrderReportController implements Initializable{ 
	
	private static Logger logger =  (Logger) LogManager.getLogger(OrderReportController.class);

    @FXML private Button CNRClear;
    @FXML private Button erOpen;
    @FXML private Button erEmail;
    @FXML private Button erEdit;
    @FXML private Button CNCreate;
    @FXML private Button erPrint;

    @FXML private ImageView reportCNImage;
    @FXML private TextField CNReportName;
    @FXML private TextArea reportDescription;
    
    @FXML private ComboBox<String> reportTypeBox;
    
    @FXML private TableView<OrderRepTable> erTable;
    @FXML private TableColumn<OrderRepTable, String> erDateColumn;
    @FXML private TableColumn<OrderRepTable, String> erNameColumn;
    @FXML private TableColumn<OrderRepTable, String> erTypeColumn;
    ObservableList<String> data = FXCollections.observableArrayList("Order revenue", "text2", "text3");
    private ObservableList<OrderRepTable> erData =  FXCollections.observableArrayList();
    
    public OrderReportController() throws IOException, SQLException {
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    	erDateColumn.setCellValueFactory( new PropertyValueFactory<>("reportDate"));
    	erNameColumn.setCellValueFactory( new PropertyValueFactory<>("reportName"));
    	erTypeColumn.setCellValueFactory( new PropertyValueFactory<>("reportType"));
    	erTable.setItems(erData);
        
    	reportTypeBox.setItems(data);
		
    	
//    	try {
//    		reportTypeBox.setItems()
//    	} catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } 
    }
    
    @FXML
    void openReport(ActionEvent event) {

    }

    @FXML
    void editReport(ActionEvent event) {

    }

    @FXML
    void printReport(ActionEvent event) {

    }

    @FXML
    void emailReport(ActionEvent event) {

    }

    @FXML
    void CreateNewReport(ActionEvent event) {
    	System.err.println("create pressed");
    }

    @FXML
    void ClearNewReport(ActionEvent event) {
    	CNReportName.setText("");
    	reportDescription.setText("");
    }
    
    @FXML
    void OnSelected(ActionEvent event) {

    }


}

