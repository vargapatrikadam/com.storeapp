package test;

import com.assignment.Classes.CODInfo;
import com.assignment.Exceptions.PaymentFailedException;
import com.assignment.Strategy.CODPayment;
import com.assignment.models.DB_Models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CODPaymentTest {

    @Test
    void payException() {
        CODPayment payment = new CODPayment();
        CODInfo info = new CODInfo();
        User user = new User();
        info.setUser(user);
        try{
            payment.Pay(info);
            assertTrue(false);
        } catch (PaymentFailedException e) {
            assertTrue(true);
        }
    }

    @Test
    void payValid(){
        CODPayment payment = new CODPayment();
        CODInfo info = new CODInfo();
        User user = new User();
        user.setStreet_number("1");
        user.setStreet("Maklári út");
        user.setCity("Eger");
        user.setPostal_code("3300");
        user.setLast_name("Verem");
        user.setFirst_name("Maki");
        info.setUser(user);
        try{
            payment.Pay(info);
            assertTrue(true);
        } catch (PaymentFailedException e) {
            assertTrue(false);
        }
    }
}