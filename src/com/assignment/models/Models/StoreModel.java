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


    /**
     * Adds a ware to the shoppingList list from the storeList by its id
     * @param id the ware's id
     */
    public void addToShoppingListById(int id){
        Ware ware = wares.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        shoppingList.add(ware);
        totalPrice += ware.getPrice();
    }

    /**
     * Removes a ware from the shoppingList list by its id
     * @param id the ware's id
     */
    public void removeFromShoppingListById(int id){
        Ware ware = shoppingList.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        shoppingList.remove(ware);
        totalPrice -= ware.getPrice();
    }

    /**
     * Populates the store list from the database with all the available wares
     * @throws SQLException
     */
    public void getAllWares() throws SQLException{
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
            throw e;
        } catch (ClassNotFoundException e) { }
    }

    public void addWare(Ware ware){
        wares.add(ware);
    }

    public void removeWare(Ware ware){
        wares.remove(ware);
    }

    /**
     * Returns a ware_type from the database by its id
     * @param id the ware_type's id
     * @return Ware_type instance
     * @throws SQLException
     */
    public Ware_type getWareTypeById(int id) throws SQLException{
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM ware_type WHERE id = ?");
            stmnt.setString(1, Integer.toString(id));
            ResultSet res = stmnt.executeQuery();
            if (!res.isBeforeFirst()) {
                throw new SQLException();
            }
            res.next();
            Ware_type type = new Ware_type();
            type.setId(Integer.parseInt(res.getString("id")));
            type.setName(res.getString("name"));
            return type;
        }
        catch (SQLException e) {
            throw e;
        }
        catch (ClassNotFoundException e) { }
        catch (NumberFormatException e) { }
        return null;
    }

    /**
     * Returns a manufacturer from the database by its id
     * @param id the manufacturer's id
     * @return Manufacturer instance
     * @throws SQLException
     */
    public Manufacturer getManufacturerById(int id) throws SQLException{
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM manufacturer WHERE id = ?");
            stmnt.setString(1, Integer.toString(id));
            ResultSet res = stmnt.executeQuery();
            if (!res.isBeforeFirst()) {
                throw new SQLException();
            }
            res.next();
            Manufacturer manu = new Manufacturer();
            manu.setId(Integer.parseInt(res.getString("id")));
            manu.setManufacturer_name(res.getString("manufacturer_name"));
            return manu;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            throw e;
        }
        return null;
    }
}
