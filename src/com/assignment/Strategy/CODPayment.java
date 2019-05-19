package com.assignment.Strategy;

import com.assignment.Classes.CODInfo;
import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.models.DB_Models.User;

public class CODPayment extends PaymentStrategy {
    @Override
    public String Pay(IPaymentInfo info) {
        CODInfo information = (CODInfo)info;
        return "Billing to " + information.getAddress();
    }
}
