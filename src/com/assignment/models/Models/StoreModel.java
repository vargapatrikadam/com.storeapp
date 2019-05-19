package com.assignment.models.Models;

import com.assignment.models.DB_Models.Manufacturer;
import com.assignment.models.DB_Models.User;
import com.assignment.models.DB_Models.Ware;
import com.assignment.models.DB_Models.Ware_type;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class StoreModel {
    public StoreModel() {
        this.shoppingList = new ArrayList<>();
        this.wares = new ArrayList<>();
    }
    public ArrayList<Ware> wares;
    public ArrayList<Ware> shoppingList;
    public ArrayList<Ware> getShoppingList() {
        return shoppingList;
    }
    private int totalPrice = 0;
    private User loggedInUser;


    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public int getTotalPrice() {
        return totalPrice;
    }



    public void addToShoppingListById(int id){
        Ware ware = wares.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        shoppingList.add(ware);
        totalPrice += ware.getPrice();
    }
    public void removeFromShoppingListById(int id){
        Ware ware = shoppingList.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        shoppingList.remove(ware);
        totalPrice -= ware.getPrice();
    }
    public void getAllWares() {
        try {
            Connection connection = DbConnector.getConnection();
            Statement stmnt = connection.createStatement();
            String statement = "SELECT * FROM ware";
            ResultSet res = stmnt.executeQuery(statement);
            while (res.next()) {
                Ware ware = new Ware();
                Ware_type type = getWareTypeById(Integer.parseInt(res.getString("ware_type_id")));
                Manufacturer manu = getManufacturerById(Integer.parseInt(res.getString("manufacturer_id")));

                ware.setId(Integer.parseInt(res.getString("id")));

                ware.setManufacturer_id(Integer.parseInt(res.getString("manufacturer_id")));
                ware.setManufacturer_name(manu.getManufacturer_name());

                ware.setWare_name(res.getString("ware_name"));
                ware.setWare_type_id(Integer.parseInt(res.getString("ware_type_id")));
                ware.setWare_type(type.getName());

                ware.setPrice(Integer.parseInt(res.getString("price")));

                wares.add(ware);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Ware_type getWareTypeById(int id) throws SQLException{
        Connection connection = DbConnector.getConnection();
        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM ware_type WHERE id = ?");
        stmnt.setString(1, Integer.toString(id));
        ResultSet res = stmnt.executeQuery();
        if(!res.isBeforeFirst()){
            throw new SQLException();
        }
        res.next();
        Ware_type type = new Ware_type();
        type.setId(Integer.parseInt(res.getString("id")));
        type.setName(res.getString("name"));
        return type;
    }
    public Manufacturer getManufacturerById(int id) throws SQLException{
        Connection connection = DbConnector.getConnection();
        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM manufacturer WHERE id = ?");
        stmnt.setString(1, Integer.toString(id));
        ResultSet res = stmnt.executeQuery();
        if(!res.isBeforeFirst()){
            throw new SQLException();
        }
        res.next();
        Manufacturer manu = new Manufacturer();
        manu.setId(Integer.parseInt(res.getString("id")));
        manu.setManufacturer_name(res.getString("manufacturer_name"));
        return manu;
    }
}
