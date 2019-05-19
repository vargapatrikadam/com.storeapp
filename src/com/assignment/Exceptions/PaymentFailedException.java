package com.assignment.Exceptions;

public class PaymentFailedException extends Exception {
    public PaymentFailedException(String errorMessage){
        super(errorMessage);
    }
}
