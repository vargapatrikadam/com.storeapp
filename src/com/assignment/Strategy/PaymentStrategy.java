package com.assignment.Strategy;

import com.assignment.Interfaces.IPaymentInfo;

public abstract class PaymentStrategy {
    public abstract String Pay(IPaymentInfo info);
}
