package test;

import com.assignment.Classes.BankCardInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankCardInfoTest {

    @Test
    void setCard_numberException() {
        BankCardInfo info = new BankCardInfo();
        try {
            info.setCard_number("asdrew123423");
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void setExp_dateException() {
        BankCardInfo info = new BankCardInfo();
        try{
            info.setExp_date("rsdf");
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    @Test
    void setCvcException() {
        BankCardInfo info = new BankCardInfo();
        try{
            info.setCvc("c4r");
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }
    @Test
    void setCard_numberValid() {
        BankCardInfo info = new BankCardInfo();
        try{
            info.setCard_number("1234567891234567");
            assertTrue(true);
        }
        catch (IllegalArgumentException e){
            assertTrue(false);
        }
    }

    @Test
    void setExp_dateValid() {
        BankCardInfo info = new BankCardInfo();
        try{
            info.setExp_date("1234");
            assertTrue(true);
        }
        catch (IllegalArgumentException e){
            assertTrue(false);
        }
    }

    @Test
    void setCvcValid() {
        BankCardInfo info = new BankCardInfo();
        try{
            info.setCvc("123");
            assertTrue(true);
        }
        catch (IllegalArgumentException e){
            assertTrue(false);
        }
    }
}