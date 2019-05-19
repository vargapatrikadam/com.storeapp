package com.assignment.Strategy;

import com.assignment.Classes.CODInfo;
import com.assignment.Exceptions.PaymentFailedException;
import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.models.DB_Models.User;

public class CODPayment extends PaymentStrategy {
    /**
     * The payment method to C.O.D
     * @param info the user's information
     * @return the message of the payment
     * @throws PaymentFailedException
     */
    @Override
    public String Pay(IPaymentInfo info) throws PaymentFailedException {
        CODInfo information = (CODInfo)info;
        if(information.getAddress() == null)
            throw new PaymentFailedException("Delivering not possible!");
        else return "Billing & delivering to " + information.getAddress();
    }
}
