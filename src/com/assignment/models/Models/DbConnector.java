package com.assignment.models.Models;

import java.sql.*;

public class DbConnector {
    private DbConnector(){

    }
    private static Connection connect;

    private static final String URL = "jdbc:mysql://nr84dudlpkazpylz.chr7pe7iynqr.eu-west-1.rds.amazonaws.com/rxz66kautu2nsm7f";
    private static final String USER = "pbsv70h8vfu5f9hq";
    private static final String PASS = "hbhv0lsicraakzpk";

    /**
     * Creates connection to the database
     * @return Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(connect == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            } catch (ClassNotFoundException e) {
                throw e;
            }
        }
        return connect;
    }
}
