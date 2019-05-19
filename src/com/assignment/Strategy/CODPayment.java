package com.assignment.Strategy;

import com.assignment.Classes.CODInfo;
import com.assignment.Exceptions.PaymentFailedException;
import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.models.DB_Models.User;

public class CODPayment extends PaymentStrategy {
    @Override
    public String Pay(IPaymentInfo info) throws PaymentFailedException {
        CODInfo information = (CODInfo)info;
        if(information.getAddress() == null) throw new PaymentFailedException("Delivering not possible!");
        else return "Billing to " + information.getAddress();
    }
}
