package com.assignment.models.Models;

import com.assignment.models.DB_Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterModel {
    /**
     * Creates a new user in the database given by the parameter
     * @param user the new user instance
     * @throws SQLException
     */
    public void Register(User user) throws SQLException{
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into user (username, password, email, first_name, last_name, postal_code, city, street, street_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            if(user.getUsername().length() < 2 || user.getCity().length() < 2 || user.getEmail().length() < 2 || user.getFirst_name().length() < 2 || user.getLast_name().length() < 2 || user.getPassword().length() < 2 || user.getPostal_code().length() < 2 || user.getStreet().length() < 2 || user.getStreet_number().length() < 2){
                throw new SQLException();
            }

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getFirst_name());
            statement.setString(5,user.getLast_name());
            statement.setString(6,user.getPostal_code());
            statement.setString(7,user.getCity());
            statement.setString(8,user.getStreet());
            statement.setString(9,user.getStreet_number());

            statement.execute();
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {}
    }
}
