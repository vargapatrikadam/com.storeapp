package com.assignment.models.Models;

import com.assignment.models.DB_Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public User Login(String username, String password) throws SQLException{
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT id, username, password, email, first_name, last_name, postal_code, city, street, street_number FROM user WHERE username = ? and password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet res = statement.executeQuery();
            if (!res.isBeforeFirst()) {
                return null;
            }
            res.next();
            User user = new User();
            user.setId(Integer.parseInt(res.getString("id")));
            user.setCity(res.getString("city"));
            user.setEmail(res.getString("email"));
            user.setFirst_name(res.getString("first_name"));
            user.setLast_name(res.getString("last_name"));
            user.setPostal_code(res.getString("postal_code"));
            user.setStreet(res.getString("street"));
            user.setStreet_number(res.getString("street_number"));
            return user;

        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) { }
        return null;
    }
}
