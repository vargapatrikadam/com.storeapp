package com.assignment.Classes;

import com.assignment.Interfaces.IPaymentInfo;
import com.assignment.models.DB_Models.User;

public class CODInfo implements IPaymentInfo {
    @Override
    public String info() {
        return "C_O_D";
    }

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() throws NullPointerException{
        if (user.getPostal_code() == null || user.getCity() == null || user.getStreet_number() == null || user.getStreet() == null || user.getFirst_name() == null || user.getLast_name() == null)
            throw new NullPointerException();
        return user.getPostal_code() + " " + user.getCity() + " " + user.getStreet() + " " + user.getStreet_number() + " " + user.getFirst_name() + " " + user.getLast_name();

    }

}
