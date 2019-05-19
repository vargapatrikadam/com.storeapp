package com.assignment.models.Models;

import java.sql.*;

public class DbConnector {
    private DbConnector(){

    }
    private static Connection connect;

    private static final String URL = "jdbc:mysql://localhost/storeappdb";
    private static final String USER = "storeappdb";
    private static final String PASS = "storeappdb";

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(connect == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException e) {
                throw e;
            } catch (ClassNotFoundException e) {
                throw e;
            }
        }
        return connect;
    }
}
