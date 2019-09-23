package ui.orderManagement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import querySet.*;
import querySet.ContactList.*;
import querySet.OrderList.*;
import querySet.ProductList.*;
import ui.mainMenu.MainMenuController;
import ui.tableView.ProductTableView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import static javafx.collections.FXCollections.observableList;
import static querySet.Query_ProductList.*;

public class OrderManagementController implements Initializable{

	private static Logger logger =  (Logger) LogManager.getLogger(OrderManagementController.class);

    @FXML
    public TextField NOProductName;
    public TextField NODateOrdered;
    public TextField NOPrimaryEmail;
    public TextField NOPEmailNotifyAt;
    public TextField NOSecondaryEmail;
    public TextField NOVendorEmail;
    public TextField NOVEmailnotifyAt;
    public TextField NOPrice;
    public TextField NOCurrency;
    public TextField NOAmount;
    public Tooltip NOCommitedToolTips;
    private ObservableList<ProductTableView> NOdata =  FXCollections.observableArrayList();


    //  private final ObservableList<ProductTableView> NOdata = FXCollections.observableArrayList(new ProductTableView("prod","1","2","3","4","5","6","7","8","9"));

    //  public TableView NOTable;
    public boolean productAdded;
    public boolean orderAdded;
    public boolean contactAdded;
    public boolean productError;
    public boolean orderError;
    public boolean contactError;
    public String ROProductName;
    public String RODateOrdered;
    public String ROPrimaryEmail;
    public String ROPEmailnotifyAt;
    public String ROSecondaryEmail;
    public String ROVendorEmail;
    public String ROPEmailNotifyAt;
    public String ROVEmailnotifyAt;
    public TextField ROPrice;
    public TextField ROCurrency;
    public TextField ROAmount;
    private final ObservableList<ProductTableView> ROdata = FXCollections.observableArrayList();

    public Integer EOProdId;
    public Integer EOrderId;

    public TextField EOProductName;
    public TextField EODateOrdered;
    public TextField EOPrimaryEmail;
    public TextField EOPEmailNotifyAt;
    public TextField EOSecondaryEmail;
    public TextField EOVendorEmail;
    public TextField EOVEmailNotifyAt;
    public TextField EOPrice;
    public TextField EOCurrency;
    public TextField EOAmount;
    private final ObservableList<ProductTableView> EOdata = FXCollections.observableArrayList();

    @FXML  public ComboBox<String> ROComboBox;


    @FXML private TableView<ProductTableView> nTable;
    @FXML private TableColumn <ProductTableView, String>prodCol;
    @FXML private TableColumn <ProductTableView, String>dateCol;
    @FXML private TableColumn <ProductTableView, String>pmailCol;
    @FXML private TableColumn <ProductTableView, String>pnotifyCol;
    @FXML private TableColumn <ProductTableView, String>smailCol;
    @FXML private TableColumn <ProductTableView, String>vmailCol;
    @FXML private TableColumn <ProductTableView, String>vnotifyCol;
    @FXML private TableColumn <ProductTableView, String>priceCol;
    @FXML private TableColumn <ProductTableView, String>currencyCol;
    @FXML private TableColumn <ProductTableView, String>amountCol;


    @FXML private TableView<ProductTableView> rTable;
    @FXML private TableColumn <ProductTableView, String>prodRCol;
    @FXML private TableColumn <ProductTableView, String>dateRCol;
    @FXML private TableColumn <ProductTableView, String>pmailRCol;
    @FXML private TableColumn <ProductTableView, String>pnotifyRCol;
    @FXML private TableColumn <ProductTableView, String>smailRCol;
    @FXML private TableColumn <ProductTableView, String>vmailRCol;
    @FXML private TableColumn <ProductTableView, String>vnotifyRCol;
    @FXML private TableColumn <ProductTableView, String>priceRCol;
    @FXML private TableColumn <ProductTableView, String>currencyRCol;
    @FXML private TableColumn <ProductTableView, String>amountRCol;
    
    @FXML  public ComboBox<String> EoComboBox;

    
    @FXML private TableView<ProductTableView> eTable;
    @FXML private TableColumn <ProductTableView, String>prodECol;
    @FXML private TableColumn <ProductTableView, String>dateECol;
    @FXML private TableColumn <ProductTableView, String>pmailECol;
    @FXML private TableColumn <ProductTableView, String>pnotifyECol;
    @FXML private TableColumn <ProductTableView, String>smailECol;
    @FXML private TableColumn <ProductTableView, String>vmailECol;
    @FXML private TableColumn <ProductTableView, String>vnotifyECol;
    @FXML private TableColumn <ProductTableView, String>priceECol;
    @FXML private TableColumn <ProductTableView, String>currencyECol;
    @FXML private TableColumn <ProductTableView, String>amountECol;

  //  @FXML private ComboBox <String> ROComboBox;

    public OrderManagementController() throws IOException, SQLException {
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
    	
    	EOProductName.setEditable(false);
        prodCol.setCellValueFactory( new PropertyValueFactory<>("product"));
        dateCol.setCellValueFactory( new PropertyValueFactory<>("date"));
        pmailCol.setCellValueFactory( new PropertyValueFactory<>("primaryEmail"));
        pnotifyCol.setCellValueFactory( new PropertyValueFactory<>("pNotifyAt"));
        smailCol.setCellValueFactory( new PropertyValueFactory<>("secondaryEmail"));
        vmailCol.setCellValueFactory( new PropertyValueFactory<>("vendorEmail"));
        vnotifyCol.setCellValueFactory( new PropertyValueFactory<>("vNotifyAt"));
        priceCol.setCellValueFactory( new PropertyValueFactory<>("price"));
        currencyCol.setCellValueFactory( new PropertyValueFactory<>("currency"));
        amountCol.setCellValueFactory( new PropertyValueFactory<>("amount"));

        nTable.setItems(NOdata);

        prodRCol.setCellValueFactory( new PropertyValueFactory<>("product"));
        dateRCol.setCellValueFactory( new PropertyValueFactory<>("date"));
        pmailRCol.setCellValueFactory( new PropertyValueFactory<>("primaryEmail"));
        pnotifyRCol.setCellValueFactory( new PropertyValueFactory<>("pNotifyAt"));
        smailRCol.setCellValueFactory( new PropertyValueFactory<>("secondaryEmail"));
        vmailRCol.setCellValueFactory( new PropertyValueFactory<>("vendorEmail"));
        vnotifyRCol.setCellValueFactory( new PropertyValueFactory<>("vnotifyAt"));
        priceRCol.setCellValueFactory( new PropertyValueFactory<>("price"));
        currencyRCol.setCellValueFactory( new PropertyValueFactory<>("currency"));
        amountRCol.setCellValueFactory( new PropertyValueFactory<>("amount"));
        rTable.setItems(ROdata);

        prodECol.setCellValueFactory( new PropertyValueFactory<>("product"));
        dateECol.setCellValueFactory( new PropertyValueFactory<>("date"));
        pmailECol.setCellValueFactory( new PropertyValueFactory<>("primaryEmail"));
        pnotifyECol.setCellValueFactory( new PropertyValueFactory<>("pnotifyAt"));
        smailECol.setCellValueFactory( new PropertyValueFactory<>("secondaryEmail"));
        vmailECol.setCellValueFactory( new PropertyValueFactory<>("vendorEmail"));
        vnotifyECol.setCellValueFactory( new PropertyValueFactory<>("vNotifyAt"));
        priceECol.setCellValueFactory( new PropertyValueFactory<>("price"));
        currencyECol.setCellValueFactory( new PropertyValueFactory<>("currency"));
        amountECol.setCellValueFactory( new PropertyValueFactory<>("amount"));
        eTable.setItems(EOdata);

        try {
            ROComboBox.setItems(Query_ProductList.selectProducts());
            System.err.println(ROComboBox);
            // Sets the edit order drop down list
            EoComboBox.setItems(Query_ProductList.selectProducts());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @FXML
    private void NOClear(ActionEvent event) {
        NOProductName.setText("");
        NODateOrdered.setText("");
        NOPrimaryEmail.setText("");
        NOPEmailNotifyAt.setText("");
        NOSecondaryEmail.setText("");
        NOVendorEmail.setText("");
        NOVEmailnotifyAt.setText("");
        NOPrice.setText("");
        NOCurrency.setText("");
        NOAmount.setText("");
    }

    @FXML
    private void ROClear(ActionEvent event) {
//        NOProductName.setText("");
//        NODateOrdered.setText("");
//        NOPrimaryEmail.setText("");
//        NOPEmailNotifyAt.setText("");
//        NOSecondaryEmail.setText("");
//        NOVendorEmail.setText("");
//        NOVEmailnotifyAt.setText("");
        ROPrice.setText("");
        ROCurrency.setText("");
        ROAmount.setText("");
    }

    @FXML
    private void EOClear(ActionEvent event) {
        EOProductName.setText("");
        EODateOrdered.setText("");
        EOPrimaryEmail.setText("");
        EOPEmailNotifyAt.setText("");
        EOSecondaryEmail.setText("");
        EOVendorEmail.setText("");
        EOVEmailNotifyAt.setText("");
        EOPrice.setText("");
        EOCurrency.setText("");
        EOAmount.setText("");
    }

    @FXML
    private void RenameSelected(ActionEvent event){
        // System.out.println("Rename has been presseed");
        EOProductName.setEditable(true);
        EOProductName.setText("");
    }



    @FXML
    private void NOAddToList(ActionEvent event){

        boolean errorFound = false;

        if(OrderManagmentHelper.isDouble(NOPrice.getText())==false){
            NOPrice.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isDouble(NOPrice.getText())==true){
            NOPrice.getStyleClass().add("validate");

        }
        if(OrderManagmentHelper.isCurrency(NOCurrency.getText())==false){
            NOCurrency.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isCurrency(NOCurrency.getText())==true){
            NOCurrency.getStyleClass().add("validate");

        }
        if(OrderManagmentHelper.isaDate(NODateOrdered.getText())==false){
            NODateOrdered.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isaDate(NODateOrdered.getText())==true){
            NODateOrdered.getStyleClass().add("validate");

        }
        if(OrderManagmentHelper.isAnAmount(NOAmount.getText())==false){
            NOAmount.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isAnAmount(NOAmount.getText())==true){
            NOAmount.getStyleClass().add("validate");

        }

        if (errorFound != true) {

            NOdata.add(new ProductTableView(NOProductName.getText(), NODateOrdered.getText(), NOPrimaryEmail.getText(),
                    NOPEmailNotifyAt.getText(), NOSecondaryEmail.getText(), NOVendorEmail.getText(),
                    NOVEmailnotifyAt.getText(), NOPrice.getText(), NOCurrency.getText(), NOAmount.getText()));

            // clears the entered values after button press
            NOClear(event);

        }
    }

    @FXML
    private void NOSubmitList(ActionEvent event) {

        ObservableList<ProductTableView> values = nTable.getItems();

        for (ProductTableView product : values) {

          //  System.out.println(product);
            int prod_id = QueryUtilities.createUniqueID();

            int order_id = QueryUtilities.createUniqueID();

            String qrBlock = product.getProduct() + Integer.toString(prod_id) + product.getDate();

            // New product list object
            ProductList newProduct = new ProductList(prod_id, product.getProduct(), product.getDate(), product.getDate(), Double.parseDouble(product.getPrice()), product.getCurrency());

            //New order list object
            OrderList newOrder = new OrderList(order_id, product.getDate(), prod_id, Integer.parseInt(product.getAmount()), Integer.parseInt(product.getAmount()), qrBlock);

            // New contact list object
            ContactList newContact = new ContactList(prod_id, product.getPrimaryEmail(), product.getSecondaryEmail(), product.getVendorEmail(), Integer.parseInt(product.getPrimaryNotify()));

            try {
                AddNewProduct(newProduct);
                productAdded = true;


            } catch (SQLException e) {
                productError = true;
                e.printStackTrace();
            }

            try {
                Query_OrderList.AddNewOrder(newOrder);
                orderAdded = true;

            } catch (SQLException e) {
                orderError = true;
                e.printStackTrace();
            }

            try {
                Query_ContactList.AddNewcontacts(newContact);
                contactAdded = true;
            } catch (SQLException e) {
                contactError = true;
                e.printStackTrace();
            }

        }

        if (contactAdded == true && productAdded == true && orderAdded == true) {
            NODeleteAll();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../popUps/SuccessfullProductCommit.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Successfully Submitted");

                stage.setScene(new Scene(root, 300, 100));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //TODO add the negative for failures

        }

        if (contactError == true) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../PopUps/ErrorContactCommit.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Error Contact commit");

                stage.setScene(new Scene(root, 300, 100));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        if (productError == true) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../PopUps/ErrorProductCommit.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Error Product commit");

                stage.setScene(new Scene(root, 300, 100));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (orderError == true) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../PopUps/ErrorOrderCommit.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Error Order commit");

                stage.setScene(new Scene(root, 300, 100));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    // Method to clear the table of items
    @FXML
    private void NODeleteAll(){
        nTable.getItems().clear();
    }
    
    @FXML
    private void RODeleteAll(){
        rTable.getItems().clear();
    }
    
    @FXML
    private void EODeleteAll(){
        eTable.getItems().clear();
    }

    @FXML
    private void ROSubmitList(ActionEvent event) throws IOException, SQLException, InterruptedException {
    	
    	ObservableList<ProductTableView> values = rTable.getItems();
    	
    	         for (ProductTableView product : values) {

            System.out.println(product);
            int prod_id = QueryUtilities.createUniqueID();

            int order_id = QueryUtilities.createUniqueID();

            String qrBlock = product.getProduct() + Integer.toString(prod_id) + product.getDate();
            
            // To differentiate between recurring orders
            LocalDate now = LocalDate.now();
            String newProdName = product.getProduct()+" "+now;
            System.out.println(newProdName);
            // New product list object
            ProductList newProduct = new ProductList(prod_id, newProdName, product.getDate(), product.getDate(), Double.parseDouble(product.getPrice()), product.getCurrency());

            //New order list object
            OrderList newOrder = new OrderList(order_id, product.getDate(), prod_id, Integer.parseInt(product.getAmount()), Integer.parseInt(product.getAmount()), qrBlock);

            // New contact list object
            ContactList newContact = new ContactList(prod_id, product.getPrimaryEmail(), product.getSecondaryEmail(), product.getVendorEmail(), Integer.parseInt(product.getPrimaryNotify()));

            try {
                AddNewProduct(newProduct);
                productAdded = true;


            } catch (SQLException e) {
                productError = true;
                e.printStackTrace();
            }

            try {
                Query_OrderList.AddNewOrder(newOrder);
                orderAdded = true;

            } catch (SQLException e) {
                orderError = true;
                e.printStackTrace();
            }

            try {
                Query_ContactList.AddNewcontacts(newContact);
                contactAdded = true;
            } catch (SQLException e) {
                contactError = true;
                e.printStackTrace();
            }
            
            finally {
            	
            	if (contactAdded == true && productAdded == true && orderAdded == true) {
                    RODeleteAll();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("../popUps/SuccessfullProductCommit.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("Successfully Submitted");

                        stage.setScene(new Scene(root, 300, 100));
                        stage.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //TODO add the negative for failures
					ROComboBox.setItems(Query_ProductList.selectProducts());
					Thread.sleep(100);

                }
            	}
    	}


    }

    @FXML
    private void EOSubmitList(ActionEvent event) throws IOException, SQLException {
    	// Edit order is an update to existing PIDS in the list
    	ObservableList<ProductTableView> values = eTable.getItems();

    	
    	for (ProductTableView product : values) {

          //  System.out.println(product);
            

            String qrBlock = product.getProduct() + EOProdId.toString() + product.getDate();

            // New product list object
            ProductList editedProduct = new ProductList(EOProdId, product.getProduct(), product.getDate(), product.getDate(), Double.parseDouble(product.getPrice()), product.getCurrency());

            //New order list object
            OrderList editedOrder = new OrderList(EOrderId, product.getDate(), EOProdId, Integer.parseInt(product.getAmount()), Integer.parseInt(product.getAmount()), "testqrblock");

            // New contact list object
            ContactList editedContact = new ContactList(EOProdId, product.getPrimaryEmail(), product.getSecondaryEmail(), product.getVendorEmail(), Integer.parseInt(product.getPrimaryNotify()));

            try {
                UpdateProductOnPID(editedProduct);
                productAdded = true;


            } catch (SQLException e) {
                productError = true;
                e.printStackTrace();
            }
    	

            try {
                Query_OrderList.updateOrderOnPID(editedOrder);
                orderAdded = true;

            } catch (SQLException e) {
                orderError = true;
                e.printStackTrace();
            }

            try {
                Query_ContactList.UpdateContactsOnPID(editedContact);
                contactAdded = true;
            } catch (SQLException e) {
                contactError = true;
                e.printStackTrace();
            }
            
            finally {                	
                	if (contactAdded == true && productAdded == true && orderAdded == true) {
                        EODeleteAll();
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("../popUps/SuccessfullProductCommit.fxml"));
                            Stage stage = new Stage();
                            stage.setTitle("Successfully Submitted");

                            stage.setScene(new Scene(root, 300, 100));
                            stage.show();
    						EoComboBox.setItems(Query_ProductList.selectProducts());

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //TODO add the negative for failures
                	
                	}
            }
    	}

    }

    // Smaller selection as it pulls data from the sQL
    @FXML
    private void ROAddToList(ActionEvent event){

        boolean errorFound = false;

        if(OrderManagmentHelper.isDouble(ROPrice.getText())==false){
            ROPrice.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isDouble(NOPrice.getText())==true){
            NOPrice.getStyleClass().add("validate");
        }
        if(OrderManagmentHelper.isCurrency(ROCurrency.getText())==false){
            ROCurrency.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isCurrency(ROCurrency.getText())==true){
            ROCurrency.getStyleClass().add("validate");

        }
//        if(OrderManagmentHelper.isaDate(RODateOrdered.getText())==false){
//            RODateOrdered.getStyleClass().add("error");
//            errorFound=true;
//
//        }
//        if(OrderManagmentHelper.isaDate(RODateOrdered.getText())==true){
//            RODateOrdered.getStyleClass().add("validate");
//        }


        if(OrderManagmentHelper.isAnAmount(ROAmount.getText())==false){
            ROAmount.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isAnAmount(ROAmount.getText())==true){
            ROAmount.getStyleClass().add("validate");

        }

        if (errorFound != true) {
            ROdata.add(new ProductTableView(ROProductName, RODateOrdered, ROPrimaryEmail,
                    ROPEmailNotifyAt, ROSecondaryEmail, ROVendorEmail,
                    ROVEmailnotifyAt, ROPrice.getText(), ROCurrency.getText(), ROAmount.getText()));

            // clears the entered values after button press
            ROClear(event);
        }
    }

    // Smaller set as pulls data from the SQL
    @FXML
    private void EOAddToList(ActionEvent event){

        boolean errorFound = false;

        if(OrderManagmentHelper.isDouble(EOPrice.getText())==false){
            EOPrice.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isDouble(EOPrice.getText())==true){
            EOPrice.getStyleClass().add("validate");
        }

        if(OrderManagmentHelper.isCurrency(EOCurrency.getText())==false){
            EOCurrency.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isCurrency(EOCurrency.getText())==true){
            EOCurrency.getStyleClass().add("validate");

        }
        if(OrderManagmentHelper.isaDate(EODateOrdered.getText())==false){
            EODateOrdered.getStyleClass().add("error");
            errorFound=true;
        }

        if(OrderManagmentHelper.isaDate(EODateOrdered.getText())==true){
            EODateOrdered.getStyleClass().add("validate");
        }

        if(OrderManagmentHelper.isAnAmount(EOAmount.getText())==false){
            EOAmount.getStyleClass().add("error");
            errorFound=true;

        }
        if(OrderManagmentHelper.isAnAmount(EOAmount.getText())==true){
            NOAmount.getStyleClass().add("validate");

        }

        if (errorFound != true) {
            EOdata.add(new ProductTableView(EOProductName.getText(), EODateOrdered.getText(), EOPrimaryEmail.getText(),
                    EOPEmailNotifyAt.getText(), EOSecondaryEmail.getText(), EOVendorEmail.getText(),
                    EOVEmailNotifyAt.getText(), EOPrice.getText(), EOCurrency.getText(), EOAmount.getText()));

            // clears the entered values after button press
            EOClear(event);
            EOAmount.getStyleClass().clear();

        }
    }

    @FXML
    private void NOdeleteItem(ActionEvent event){
        int selectionindex = nTable.getSelectionModel().getSelectedIndex();
        if (selectionindex >=0){
            nTable.getItems().remove(selectionindex);
        }

    }

    @FXML
    private void ROdeleteItem(ActionEvent event){
        int selectionindex = rTable.getSelectionModel().getSelectedIndex();
        if (selectionindex >=0){
            rTable.getItems().remove(selectionindex);
        }

    }

    @FXML
    private void EOdeleteItem(ActionEvent event){
        int selectionindex = eTable.getSelectionModel().getSelectedIndex();
        if (selectionindex >=0){
            eTable.getItems().remove(selectionindex);
        }

    }

    public  ObservableList getInitilaNOdata() throws IOException, SQLException {

        ArrayList value = selectProductAndLot();
        System.err.println(value);
        return observableList(value);
    }


    public void GetProdInfo(Event event) {
    }

    public void OnSelected(ActionEvent actionEvent) throws IOException, SQLException {
        String product = ROComboBox.getSelectionModel().getSelectedItem();
        System.out.println(product);

        ArrayList<Object> result = Query_ProductList.selectAllOnProduct(product);
        System.out.println("values");
        System.out.println(result);
        
        
        ROProductName = String.valueOf(result.get(1));
        RODateOrdered = String.valueOf(result.get(2));
        
        ROPrimaryEmail = String.valueOf(result.get(13));
        ROSecondaryEmail = String.valueOf(result.get(14));
        ROVendorEmail = String.valueOf(result.get(15));
        ROPEmailNotifyAt = result.get(16).toString();
        ROVEmailnotifyAt = result.get(16).toString();
        
        ROPrice.setText(String.valueOf(result.get(4)));
        ROCurrency.setText(String.valueOf(result.get(5)));
        ROAmount.setText(String.valueOf(result.get(10)));


    }

    public void EoOnSelected(ActionEvent actionEvent) throws IOException, SQLException {
    	String product = EoComboBox.getSelectionModel().getSelectedItem();
        System.out.println(product);
        
        ArrayList<Object> resultProdLot = Query_ProductList.selectAllOnProduct(product);
        System.out.println("values");
        System.out.println(resultProdLot);
        
        // EOProdId is used to edit an existing product
        EOProdId = Integer.parseInt(String.valueOf(resultProdLot.get(0)));
        EOrderId = Integer.parseInt(String.valueOf(resultProdLot.get(6)));
       
        EOProductName.setText(String.valueOf(resultProdLot.get(1)));
        EODateOrdered.setText(String.valueOf(resultProdLot.get(2)));
        
        EOPrice.setText(String.valueOf(resultProdLot.get(4)));
        EOCurrency.setText(String.valueOf(resultProdLot.get(5)));
        EOAmount.setText(String.valueOf(resultProdLot.get(10)));
        
        EOPrimaryEmail.setText(String.valueOf(resultProdLot.get(13)));
        EOSecondaryEmail.setText(String.valueOf(resultProdLot.get(14)));
        EOVendorEmail.setText(String.valueOf(resultProdLot.get(15)));
        EOPEmailNotifyAt.setText((resultProdLot.get(16).toString()));
        EOVEmailNotifyAt.setText(resultProdLot.get(16).toString());
        
    }
}
