package com.assignment.models.Models;

import java.sql.*;

public class DbConnector {
    private DbConnector(){

    }
    private static Connection connect;

    private static final String URL = "jdbc:mysql://localhost/storeappdb";
    private static final String USER = "storeappdb";
    private static final String PASS = "storeappdb";

    public static Connection getConnection(){
        if(connect == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
