package tests.orderManagement;

import org.junit.jupiter.api.Test;

import ui.orderManagement.OrderManagmentHelper;
import ui.orderManagement.OrderManagmentHelper.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OrderManagementTests {

    @Test
    void testDoubleCheck(){
        Double doubleValue = OrderManagmentHelper.checkDouble("4.20");

        Double value = 4.2;

        assertEquals(value ,doubleValue);
    }

    @Test
    void testNotDoubleCheck() throws NumberFormatException{
         Throwable exception = assertThrows(RuntimeException.class,
                 ()->{OrderManagmentHelper.checkDouble("Mexicola");});

    }

    @Test
    void testDateFormat1(){
        Boolean dateFound = OrderManagmentHelper.isaDate("22/09/1993");

        assertEquals(true,dateFound);
    }

    @Test
    void testDateFormat2(){
        Boolean dateFound = OrderManagmentHelper.isaDate("1993/09/22");

        assertEquals(false,dateFound);
    }

}
