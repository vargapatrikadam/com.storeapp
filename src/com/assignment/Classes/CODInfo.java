package com.assignment.Classes;

import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.models.DB_Models.User;

public class CODInfo implements IPaymentInfo {
    @Override
    public IPaymentInfo info() {
        return this;
    }

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return user.getPostal_code() + " " + user.getCity() + " " + user.getStreet() + " " + user.getStreet_number() + " " + user.getFirst_name() + " " + user.getLast_name();

    }

    private String address;


}
