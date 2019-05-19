package com.assignment.Strategy;

import com.assignment.Classes.BankCardInfo;
import com.assignment.Exceptions.PaymentFailedException;
import com.assignment.Interfaces.IPaymentInfo;

public class BankCardPayment extends PaymentStrategy {
    @Override
    public String Pay(IPaymentInfo info) throws PaymentFailedException {
        if(Transaction(info)){
            return "Transaction successful!";
        }
        else{
            throw new PaymentFailedException("Transaction failed!");
        }
    }
    private boolean Transaction(IPaymentInfo info){
        BankCardInfo information = (BankCardInfo)info;
        if(information.getCard_number().length() == 16 && information.getCvc().length() == 3 && information.getExp_date().length() == 4)
            return true;
        else return false;
    }
}
