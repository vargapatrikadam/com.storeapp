package com.assignment.Strategy;

import com.assignment.Classes.BankCardInfo;
import com.assignment.Exceptions.PaymentFailedException;
import com.assignment.Interfaces.IPaymentInfo;

public class BankCardPayment extends PaymentStrategy {
    /**
     * The payment method for paying with a bank card
     * @param info The bank card's and the user's information
     * @return the message of the payment
     * @throws PaymentFailedException
     */
    @Override
    public String Pay(IPaymentInfo info) throws PaymentFailedException {
        BankCardInfo information = (BankCardInfo)info;
        if(Transaction(information)){
            return "Transaction successful! Delivering to " + information.getAddress();
        }
        else{
            throw new PaymentFailedException("Transaction failed!");
        }
    }

    /**
     * Checks whether the bank card's details are valid
     * @param information bank card's information
     * @return true if the bank card's details are valid, and false if they're not
     */
    private boolean Transaction(BankCardInfo information){
        if(information.getCard_number().length() == 16 && information.getCvc().length() == 3 && information.getExp_date().length() == 4)
            return true;
        else return false;
    }
}
