package com.assignment.Classes;

import com.assignment.Interfaces.IPaymentInfo;

public class BankCardInfo implements IPaymentInfo {
    @Override
    public IPaymentInfo info() {
        return this;
    }
    private String card_number;
    private String exp_date;
    private String cvc;

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

}
