package com.assignment.models.Models;

import com.assignment.models.DB_Models.PaymentMethod;
import com.assignment.models.DB_Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMethodModel {
    public PaymentMethod getPaymentMethodByName(String name) {
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT id, method FROM payment_method WHERE method = ?");
            statement.setString(1, name);
            ResultSet res = statement.executeQuery();
            if (!res.isBeforeFirst()) {
                return null;
            }
            res.next();
            PaymentMethod method = new PaymentMethod();
            method.setId(Integer.parseInt(res.getString("id")));
            method.setMethod(res.getString("method"));
            return method;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}