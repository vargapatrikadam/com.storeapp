package com.assignment.models.Models;

import com.assignment.models.DB_Models.PaymentMethod;
import com.assignment.models.DB_Models.User;
import com.assignment.models.DB_Models.Ware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WareReceiptModel {
    /**
     * Adds wares to the receipt with the given id from the wares list
     * @param wares the wares list
     * @param id the receipt's id
     * @throws SQLException
     */
    public void createWareReceipt(ArrayList<Ware> wares, long id) throws SQLException{
        try {
            Connection connection = DbConnector.getConnection();

            for(Ware ware : wares) {
                PreparedStatement receiptWaresStatement = connection.prepareStatement("INSERT INTO ware_receipt (ware_id, receipt_id) VALUES (?, ?)");
                receiptWaresStatement.setString(1, Integer.toString(ware.getId()));
                receiptWaresStatement.setString(2, Long.toString(id));

                receiptWaresStatement.execute();
            }
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) { }
    }
}