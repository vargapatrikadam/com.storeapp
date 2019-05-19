package com.assignment.models.Models;

import java.sql.*;

public class DbConnector {
    private DbConnector(){

    }
    private static Connection connect;
    public static Connection getConnection(){
        if(connect == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection("jdbc:mysql://localhost/storeappdb","storeappdb","storeappdb");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
