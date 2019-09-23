package querySet;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import ui.orderManagement.OrderManagementController;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Contains the initial set of sql queries for the table product list
 */
public class Query_ProductList {
//     Todo see if the connection variable is needed in each class
//    private static Connection connection;

    private static Connection connection;

	private static Logger logger =  (Logger) LogManager.getLogger(Query_ProductList.class);


    public static void AddNewProduct(ProductList updateValues) throws SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();
            if (connection != null) {

                PreparedStatement insertProducts = connection.prepareStatement(
                        "INSERT INTO public.products_list values(?,?,?,?,?,?)"
                );



                insertProducts.setDouble(1, updateValues.getProd_id());
                insertProducts.setString(2, updateValues.getProductName());
                insertProducts.setDate(3, Date.valueOf(updateValues.getInitialOrderDate()));
                insertProducts.setDate(4, Date.valueOf(updateValues.getCurrentOrderDate()));
                insertProducts.setDouble(5, updateValues.getPrice());
                insertProducts.setString(6, updateValues.getCurrency());
                
                logger.info("Query generated: "+ insertProducts.toString());
                
                insertProducts.executeUpdate();
                logger.info("Product update commited");
            } else {
            	logger.info("Failed to connect");
            }


        } catch (Exception e) {
            System.out.println("connection failed: ");

            e.printStackTrace();

        }

    }
    
    public static void UpdateProductOnPID(ProductList updateValues) throws SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();
            if (connection != null) {

                PreparedStatement insertProducts = connection.prepareStatement(
                        "UPDATE public.products_list SET productname= ?, init_orderdate=?, curr_orderdate =?, rup =? , currency =? WHERE products_list.prod_id=?"
                );


              //  insertProducts.setDouble(1, updateValues.getProd_id());
                insertProducts.setString(1, updateValues.getProductName());
                insertProducts.setDate(2, Date.valueOf(updateValues.getInitialOrderDate()));
                insertProducts.setDate(3, Date.valueOf(updateValues.getCurrentOrderDate()));
                insertProducts.setDouble(4, updateValues.getPrice());
                insertProducts.setString(5, updateValues.getCurrency());
                
                insertProducts.setDouble(6, updateValues.getProd_id());

                
                logger.info("Query generated: "+ insertProducts.toString());
                
                insertProducts.executeUpdate();
                logger.info("Product update commited");
            } else {
            	logger.info("Failed to connect");
            }


        } catch (Exception e) {
            System.out.println("connection failed: ");

            e.printStackTrace();

        }

    }

    public static ArrayList<Object> selectRowOnProductName(String productName) throws SQLException, IOException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {



                PreparedStatement selectQuery = connection.prepareStatement(
                        "SELECT * FROM public.products_list WHERE products_list.productname=?");

                selectQuery.setString(1, productName);
                ResultSet results = selectQuery.executeQuery();
                ArrayList<Object> returnedProducts = new ArrayList<>();


                while (results.next()) {
                    returnedProducts.add(results.getInt(1));

                    returnedProducts.add(results.getString(2));
                    returnedProducts.add(results.getString(3));
                    returnedProducts.add(results.getString(4));
                    returnedProducts.add(results.getDouble(5));
                    returnedProducts.add(results.getString(6));


                }
                connection.close();
                return returnedProducts;
            } else {


                throw new SQLException("Unable to find: " + productName);

            }

        } catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }
    }


    // TODO continue refactor
    public static ArrayList<Object> selectRowOnProduct_id(int prod_id) throws SQLException, IOException {

        try {

            Connection connection = PostgresConnector.connectWithCredentials();
            if (connection != null) {

                PreparedStatement selectQuery = connection.prepareStatement(
                        "SELECT * FROM public.products_list WHERE products_list.prod_id=?");


                selectQuery.setInt(1, prod_id);
                ResultSet results = selectQuery.executeQuery();
                ArrayList<Object> returnedProducts = new ArrayList<>();

                while (results.next()) {
                    returnedProducts.add(results.getInt(1));

                    returnedProducts.add(results.getString(2));
                    returnedProducts.add(results.getString(3));
                    returnedProducts.add(results.getString(4));
                    returnedProducts.add(results.getDouble(5));
                    returnedProducts.add(results.getString(6));


                }
                return returnedProducts;
            } else {


                throw new SQLException("Unable to find: " + prod_id);

            }
        }catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }


    }

    // update queries act on prod_id
    public static void updateProductName(String newProductName, int prod_id) throws IOException, SQLException {


        try {
            connection = PostgresConnector.connectWithCredentials();
            if (connection != null) {

                PreparedStatement updateQuery = connection.prepareStatement(
                        "UPDATE public.products_list SET productname= ? WHERE products_list.prod_id=?");

                updateQuery.setString(1, newProductName);
                updateQuery.setInt(2, prod_id);
                updateQuery.executeUpdate();

                System.out.println("The item with product id: " + prod_id + "now has the name" + newProductName);

            }

        } catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }
    }


    public static ObservableList<String> selectProducts() throws IOException, SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {

                PreparedStatement selectContacts = connection.prepareStatement(
                        "SELECT products_list.productname from public.products_list WHERE products_list.productname is not null"
                );

                ResultSet results = selectContacts.executeQuery();
                ObservableList<String> returnedContacts = FXCollections.observableArrayList();

                while (results.next()) {
                    returnedContacts.add(results.getString(1));

                }
                connection.close();
                return returnedContacts;
            } else {
                throw new SQLException("unable to find: any items" );
            }
        }
        catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }

    }

    // FIXME
    public static ArrayList<Object> selectProductOnPID(int prod_id) throws IOException, SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {

                PreparedStatement selectContacts = connection.prepareStatement(
                        "SELECT trigger_level from public.products_list WHERE products_list.prod_id= ?"
                );

                selectContacts.setInt(1, prod_id);
                ResultSet results = selectContacts.executeQuery();
                ArrayList<Object> returnedContacts = new ArrayList<>();

                while (results.next()) {
                    returnedContacts.add(results.getString(1));

                }
                connection.close();
                return returnedContacts;
            } else {
                throw new SQLException("unable to find: " + prod_id);
            }
        }
        catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }

    }


    public static ArrayList<Object> selectProductAnd2Lot(String product)throws IOException, SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {

                PreparedStatement selectProducts = connection.prepareStatement(
                        "SELECT * from public.products_list" +
                                " JOIN orders_list ON products_list.prod_id = orders_list.prod_id " +
                                "WHERE products_list.productname= ?"
                );

                selectProducts.setString(1, product);

                ResultSet results = selectProducts.executeQuery();
                ArrayList<Object> returnedProducts = new ArrayList<>();

                while (results.next()) {
                    returnedProducts.add(results.getString(1));
                    returnedProducts.add(results.getString(2));
                    returnedProducts.add(results.getString(3));
                    returnedProducts.add(results.getString(4));
                    returnedProducts.add(results.getString(5));
                    returnedProducts.add(results.getString(6));
                    returnedProducts.add(results.getString(7));
                    returnedProducts.add(results.getString(8));
                    returnedProducts.add(results.getString(9));
                    returnedProducts.add(results.getString(10));
                    returnedProducts.add(results.getString(11));
                    returnedProducts.add(results.getString(12));




                }
                connection.close();
                return returnedProducts;
            } else {
                throw new SQLException("No products found");
            }
        }
        catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }

    }
    
    public static ArrayList<Object> selectProductsInventory()throws IOException, SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {

                PreparedStatement selectProducts = connection.prepareStatement(
                        "SELECT  products_list.productname, products_list.curr_orderdate , orders_list.remaining_lot, orders_list.lot_size ,products_list.prod_id from public.products_list" +
                                " JOIN orders_list ON products_list.prod_id = orders_list.prod_id"
                );

               // selectProducts.setString(1, product);

                ResultSet results = selectProducts.executeQuery();
                ArrayList<Object> returnedProducts = new ArrayList<>();

                while (results.next()) {
                    returnedProducts.add(results.getString(1));
                    returnedProducts.add(results.getString(2));
                    returnedProducts.add(results.getString(3));
                    returnedProducts.add(results.getString(4));
                    returnedProducts.add(results.getString(5));

                }
                connection.close();
                return returnedProducts;
            } else {
                throw new SQLException("No products found");
            }
        }
        catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }

    }
    
    public static ArrayList<Object> selectAllOnProduct(String product)throws IOException, SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {

                PreparedStatement selectProducts = connection.prepareStatement(
                        "SELECT * from public.products_list" +
                                " INNER JOIN orders_list ON products_list.prod_id = orders_list.prod_id " +
                                " INNER JOIN contact_list ON products_list.prod_id = contact_list.prod_id " +
                                "WHERE products_list.productname= ?"
                );

                selectProducts.setString(1, product);

                ResultSet results = selectProducts.executeQuery();
                ArrayList<Object> returnedProducts = new ArrayList<>();

                while (results.next()) {
                    returnedProducts.add(results.getString(1));
                    returnedProducts.add(results.getString(2));
                    returnedProducts.add(results.getString(3));
                    returnedProducts.add(results.getString(4));
                    returnedProducts.add(results.getString(5));
                    returnedProducts.add(results.getString(6));
                    returnedProducts.add(results.getString(7));
                    returnedProducts.add(results.getString(8));
                    returnedProducts.add(results.getString(9));
                    returnedProducts.add(results.getString(10));
                    returnedProducts.add(results.getString(11));
                    returnedProducts.add(results.getString(12));
                    returnedProducts.add(results.getString(13));
                    returnedProducts.add(results.getString(14));
                    returnedProducts.add(results.getString(15));
                    returnedProducts.add(results.getString(16));
                    returnedProducts.add(results.getString(17));
                    
                }
                connection.close();
                return returnedProducts;
            } else {
                throw new SQLException("No products found");
            }
        }
        catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }

    }

    public static ArrayList<Object> selectProductAndLot()throws IOException, SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {

                PreparedStatement selectProducts = connection.prepareStatement(
                        "SELECT products_list.productName, orders_list.remaining_lot, products_list.prod_id  " +
                                "from public.products_list JOIN orders_list ON products_list.prod_id = orders_list.prod_id"
                );

                ResultSet results = selectProducts.executeQuery();
                ArrayList<Object> returnedProducts = new ArrayList<>();

                while (results.next()) {
                    returnedProducts.add(results.getString(1));
                    returnedProducts.add(results.getString(2));
                    returnedProducts.add(results.getString(3));


                }
                connection.close();
                return returnedProducts;
            } else {
                throw new SQLException("No products found");
            }
        }
        catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }

    }

    public static void updateRUP(double newRUP, int prod_id) throws IOException, SQLException {

        try {
            Connection connection = PostgresConnector.connectWithCredentials();
            if (connection != null) {

                PreparedStatement updateQuery = connection.prepareStatement(
                        "UPDATE public.products_list SET RUP= ? WHERE products_list.prod_id=?");

                updateQuery.setDouble(1, newRUP);
                updateQuery.setInt(2, prod_id);
                updateQuery.executeUpdate();

                System.out.println("The item with product id: " + prod_id + "now has the Rough unit price: " + newRUP);

                connection.close();

            }

        } catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }
    }

    public static void updateCurrency(String newCurrency, int prod_id) throws IOException, SQLException {
        try {
            Connection connection = PostgresConnector.connectWithCredentials();
            if (connection != null) {

                PreparedStatement updateQuery = connection.prepareStatement(
                        "UPDATE public.products_list SET currency= ? WHERE products_list.prod_id=?");

                updateQuery.setString(1, newCurrency);
                updateQuery.setInt(2, prod_id);
                updateQuery.executeUpdate();

                System.out.println("The item with product id: " + prod_id + "now has the Currency: " + newCurrency);

            }

        } catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }
    }
    
    public static void updateROItems(String newCurrency, int prod_id) throws IOException, SQLException {
        try {
            Connection connection = PostgresConnector.connectWithCredentials();
            if (connection != null) {

                PreparedStatement updateQuery = connection.prepareStatement(
                        "UPDATE public.products_list SET price= ? currency= ? amount=? WHERE products_list.prod_id=?");

                updateQuery.setString(1, newCurrency);
                updateQuery.setInt(2, prod_id);
                updateQuery.executeUpdate();

                System.out.println("The item with product id: " + prod_id + "now has the Currency: " + newCurrency);

            }

        } catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }
    }


    public static void deleteProduct(int prod_id) throws IOException, SQLException {
        try {
            Connection connection = PostgresConnector.connectWithCredentials();

            if (connection != null) {

                PreparedStatement updateQuery = connection.prepareStatement(
                        "DELETE FROM public.products_list WHERE products_list.prod_id=?");

                updateQuery.setInt(1, prod_id);
                updateQuery.executeUpdate();

                connection.close();

                System.out.println("The item with product id: " + prod_id + "has now been deleted");

            }


        }
        catch (SQLException e){
            throw new SQLException("Unable to connect", e);
        }
    }

    public static void main(String[] args) throws IOException, SQLException {


//        ProductList newProdList = new ProductList(111,"hasmmer", "2018-09-09"
//                , "2018-09-09", 12.00, "GBP");
//
//
//        AddNewProduct(newProdList);
        //  System.out.println(selectRowOnProductName("Mobile Armour"));
        System.out.println(selectProductsInventory());
    }
}
