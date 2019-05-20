package com.assignment.Classes;

import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.models.DB_Models.User;

import java.util.IllegalFormatException;

public class BankCardInfo implements IPaymentInfo {
    @Override
    public String info() {
        return "BANK_CARD";
    }
    private String card_number;
    private String exp_date;
    private String cvc;

    public String getCard_number() {
        return card_number;
    }

    /**
     * Sets the card number for the bank card, only 16 numbers.
     * @param card_number the card number
     */
    public void setCard_number(String card_number) throws IllegalArgumentException{
        if (card_number.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("The card number cannot contain letters!");
        }
        this.card_number = card_number;
    }

    public String getExp_date(){
        return exp_date;
    }

    /**
     * Sets the expiration date for the bank card, only 4 characters.
     * @param exp_date the expiration date
     */
    public void setExp_date(String exp_date) throws IllegalArgumentException{
        if (exp_date.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("The expiration date cannot contain letters!");
        }
        this.exp_date = exp_date;
    }

    public String getCvc() {
        return cvc;
    }

    /**
     * Sets the cvc validation code for the bank card, only 3 numbers;
     * @param cvc cvc number
     */
    public void setCvc(String cvc) throws IllegalArgumentException{
        if (cvc.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("The cvc cannot contain letters!");
        }
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
