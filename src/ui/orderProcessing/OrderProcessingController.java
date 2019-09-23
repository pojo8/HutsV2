package ui.orderProcessing;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.tableView.OrderProcessingTable;
import querySet.QueryUtilities;
import querySet.Query_OrderList;
import querySet.Query_ProductList;


public class OrderProcessingController implements Initializable{
	
	// private static Boolean hasAdminPermissions = false;
    @FXML private Button reduceInventory;    
    @FXML private Button amendInventory;
    
    @FXML private TextField alterStock;
    
    @FXML private TableView<OrderProcessingTable> stockViewTable;
    @FXML private TableColumn<OrderProcessingTable, String> dateColumn;    
    @FXML private TableColumn<OrderProcessingTable, String> currentStockColumn;    
    @FXML private TableColumn<OrderProcessingTable, String> prodColumn;
    @FXML private TableColumn<OrderProcessingTable, String> initialStockColumn;
    @FXML private TableColumn<OrderProcessingTable, String> prodIdColumn;

    @FXML
    private ScrollPane tableScrollPane;
    
    // private final ObservableList<OrderProcessingTable> stockData = FXCollections.observableArrayList();
    
    private final ObservableList<OrderProcessingTable> stockData = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    	// initTableData();
    	prodColumn.setCellValueFactory( new PropertyValueFactory<>("prodName"));
        dateColumn.setCellValueFactory( new PropertyValueFactory<>("prodDate"));
        currentStockColumn.setCellValueFactory( new PropertyValueFactory<>("currentStock"));
        initialStockColumn.setCellValueFactory( new PropertyValueFactory<>("initialStock"));
        prodIdColumn.setCellValueFactory( new PropertyValueFactory<>("prodId"));
    	// stockViewTable.setItems(stockData);
    	
    	try {
    		List<List<Object>> results = QueryUtilities.fiveResultssplit(Query_ProductList.selectProductsInventory());
    		
    		for(int i = 0 ; i< results.size(); i ++) {
    			
    			List <Object>processingSet =  results.get(i);
    			
    			OrderProcessingTable processingElement =  new OrderProcessingTable( processingSet.get(0).toString(), processingSet.get(1).toString(),
    					processingSet.get(2).toString(), processingSet.get(3).toString(), processingSet.get(4).toString());    			
    			
    			stockData.add( processingElement);
    		}
    		stockViewTable.setItems(stockData);
    		
    	} catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
    
    private void reinitTableData() {

    	try {
    		List<List<Object>> results = QueryUtilities.fiveResultssplit(Query_ProductList.selectProductsInventory());
    		
    		for(int i = 0 ; i< results.size(); i ++) {
    			
    			List <Object>processingSet =  results.get(i);
    			
    			OrderProcessingTable processingElement =  new OrderProcessingTable( processingSet.get(0).toString(), processingSet.get(1).toString(),
    					processingSet.get(2).toString(), processingSet.get(3).toString(), processingSet.get(4).toString());    			
    			
    			//stockData.add( processingElement);
    			stockData.set(i, processingElement);

    		}
    		stockViewTable.setItems(stockData);
    		
    		
    	} catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    void reduceStock(ActionEvent event) throws IOException, NumberFormatException, SQLException {
    	// System.out.println(stockViewTable.getSelectionModel().getSelectedItem());
    	if (stockViewTable.getSelectionModel().getSelectedItem() != null) {
    	
    		int decreaseAmount = Integer.parseInt(alterStock.getText());
	    	int currentStock = Integer.parseInt(stockViewTable.getSelectionModel().getSelectedItem().getCurrentStock());
    		
	    	if(currentStock - decreaseAmount >= 0) {
    		
		    	// Do SQL statement
		    	String prod_id = stockViewTable.getSelectionModel().getSelectedItem().getProdId();
		    	Query_OrderList.decreaseCurrentLotBy(Integer.parseInt(prod_id), decreaseAmount);
		    	alterStock.setText("");

		    	reinitTableData();
	    	} else {
	    		Parent root = FXMLLoader.load(getClass().getResource("../popUps/ErrorStockBelowZero.fxml"));
	            Stage stage = new Stage();
	            stage.setTitle("Error select an item");
	            stage.setScene(new Scene(root, 438, 100));
	            stage.show();
	    	}
    	} else {
    		Parent root = FXMLLoader.load(getClass().getResource("../popUps/ErrorSelectTableItem.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Error select an item");
            stage.setScene(new Scene(root, 300, 100));
            stage.show();
    	}
    	
    }

    @FXML
    void amendStock(ActionEvent event) throws IOException, NumberFormatException, SQLException {
    	
    	// rethink post close of modal maybe show passwor dfields
    	if (stockViewTable.getSelectionModel().getSelectedItem() != null) { 
    	// FIXME add a password guard for amending the order	
//    	 Parent root = FXMLLoader.load(getClass().getResource("../popUps/AdminPasswordPopup.fxml"));
//         Stage stage = new Stage();
//
//         stage.setTitle("Trail Report");
//         stage.setOnCloseRequest(null);
//         stage.setScene(new Scene(root, 340, 185));
//         stage.show();
         
         increaseCurentStock();
         
    	} else {
    		Parent root = FXMLLoader.load(getClass().getResource("../popUps/ErrorSelectTableItem.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Error select an item");
            stage.setOnCloseRequest(null);
            stage.setScene(new Scene(root, 300, 100));
            stage.show();
    	}
    }
    
    
    
    
    private void increaseCurentStock() throws IOException, NumberFormatException, SQLException {
    	
    	
    		int increaseAmount = Integer.parseInt(alterStock.getText());
	    	int initialStock = Integer.parseInt(stockViewTable.getSelectionModel().getSelectedItem().getInitialStock());
	    	int currentStock = Integer.parseInt(stockViewTable.getSelectionModel().getSelectedItem().getCurrentStock());

	    	
	    	String prod_id = stockViewTable.getSelectionModel().getSelectedItem().getProdId();
	    	
	    	if(increaseAmount + currentStock <= initialStock) {
	    	// Do the SQl statement for it
	    	   Query_OrderList.increaseCurrentLotBy(Integer.parseInt(prod_id), increaseAmount);
	    	   alterStock.setText("");
	    	   // reloads table data after change
	    	   reinitTableData();
	    	} else {
	    		Parent root = FXMLLoader.load(getClass().getResource("../popUps/ErrorSelectTableItem.fxml"));
	            Stage stage = new Stage();
	            stage.setTitle("Error select an item");
	            stage.setOnCloseRequest(null);
	            stage.setScene(new Scene(root, 438, 100));
	            stage.show();
	    	}
    	
    	
    }

}
