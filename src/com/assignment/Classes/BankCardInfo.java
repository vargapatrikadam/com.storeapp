package com.assignment.Classes;

import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.models.DB_Models.User;

public class BankCardInfo implements IPaymentInfo {
    @Override
    public String info() {
        return "BANK_CARD";
    }
    private String card_number;
    private String exp_date;
    private String cvc;
    private String address;

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

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return user.getPostal_code() + " " + user.getCity() + " " + user.getStreet() + " " + user.getStreet_number() + " " + user.getFirst_name() + " " + user.getLast_name();

    }
}
