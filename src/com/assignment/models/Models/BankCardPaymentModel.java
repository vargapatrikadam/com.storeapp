package com.assignment.models.Models;

public class BankCardPaymentModel {
    public String getBank_card_number() {
        return bank_card_number;
    }

    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number;
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

    private String bank_card_number;
    private String exp_date;
    private String cvc;
}
