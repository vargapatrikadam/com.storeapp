package test;

import com.assignment.Classes.BankCardInfo;
import com.assignment.Exceptions.PaymentFailedException;
import com.assignment.Strategy.BankCardPayment;
import com.assignment.models.DB_Models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankCardPaymentTest {

    @Test
    void payPaymentFailedException() {
        BankCardPayment payment = new BankCardPayment();
        BankCardInfo info = new BankCardInfo();
        User user = new User();
        info.setUser(user);
        info.setCard_number("1234");
        info.setCvc("1");
        info.setExp_date("4324");

        try {
            payment.Pay(info);
            assertTrue(false);
        } catch (PaymentFailedException e) {
            assertTrue(true);
        }
    }
    @Test
    void payNullPointerException() {
        BankCardPayment payment = new BankCardPayment();
        BankCardInfo info = new BankCardInfo();
        info.setExp_date("1234");
        info.setCvc("123");
        info.setCard_number("1234567891234567");

        try {
            payment.Pay(info);
            assertTrue(false);
        } catch (PaymentFailedException e) {
            assertTrue(false);
        } catch (NullPointerException e){
            assertTrue(true);
        }
    }
    @Test
    void payCorrectDetails() {
        BankCardPayment payment = new BankCardPayment();
        BankCardInfo info = new BankCardInfo();
        info.setExp_date("1234");
        info.setCvc("123");
        info.setCard_number("1234567891234567");
        User user = new User();
        info.setUser(user);

        try {
            payment.Pay(info);
            assertTrue(true);
        } catch (Exception e){
            assertTrue(false);
        }
    }

    @Test
    void transactionException() {
        BankCardPayment payment = new BankCardPayment();
        BankCardInfo info = new BankCardInfo();
        try{
            payment.Transaction(info);
            assertTrue(false);
        }catch (NullPointerException e){
            assertTrue(true);
        }
    }
    @Test
    void transactionSuccessful(){
        BankCardPayment payment = new BankCardPayment();
        BankCardInfo info = new BankCardInfo();
        info.setExp_date("1234");
        info.setCvc("123");
        info.setCard_number("1234567891234567");

        if (payment.Transaction(info)){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }

}