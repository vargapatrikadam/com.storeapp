package com.assignment.models.Models;

import com.assignment.models.DB_Models.PaymentMethod;
import com.assignment.models.DB_Models.User;
import com.assignment.models.DB_Models.Ware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReceiptModel {
    public long createReceipt(User user, PaymentMethod paymentMethod){
        try {
            Connection connection = DbConnector.getConnection();

            String generatedColumns[] = {"id"};

            PreparedStatement receiptStatement = connection.prepareStatement("INSERT INTO receipt (payment_method_id, user_id) VALUES (?,?)", generatedColumns);

            receiptStatement.setString(1,Integer.toString(paymentMethod.getId()));
            receiptStatement.setString(2,Integer.toString(user.getId())
            );

            receiptStatement.execute();

            ResultSet res = receiptStatement.getGeneratedKeys();
            long id = 0;
            if(res.next()){
                id = res.getLong(1);
            }

            return id;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
