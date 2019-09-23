package ui.orderManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.lang.Double;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderManagmentHelper {

    public static ArrayList<Object> collectTextFieldsNo(String productName, String date, String primaryEmail, String notifyAtPe,
                                                      String secondaryEmail, String vendorEmail, String notifyAtVe,
                                                        String price, String currency, String amount ){

        ArrayList<Object> checkedFields = new ArrayList<Object>();

        return checkedFields;
    }


    public static Double checkDouble(String input){

        try{
            Double.parseDouble(input);

        }
        catch(NumberFormatException e){
            throw new NumberFormatException("Not a double");
        }

        return Double.valueOf(input);

    }

    public static boolean isDouble(String input){

        try{
            Double.parseDouble(input);

        }
        catch(NumberFormatException e){
            return false;
        }
        return true;

    }

    public static boolean isCurrency(String input){

        Pattern currencyCode = Pattern.compile("[A-Z]{3}");
        Matcher m = currencyCode.matcher(input);

        int lengthCode = input.length();

        if(m.find() && lengthCode ==3){
            return true;
        }

        return false;

    }

    public static boolean isAnAmount(String input){

        try{
            Integer.parseInt(input);

        }
        catch(NumberFormatException e){
            return false;
        }
        return true;

    }

    public static boolean isaDate(String input){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(input, formatter);

        }
        catch(DateTimeParseException exp){
            return false;
        }

        return true;

    }

    public static void main(String [] Args){
//
//        String nonDouble = "abacus";
//
//        String doubled ="4.72";
//
//        checkDouble(nonDouble);
//
//
    }
}
