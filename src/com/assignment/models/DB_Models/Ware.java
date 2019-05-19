package com.assignment.models.DB_Models;

public class Ware {
    private int id;
    private String ware_name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;
    private int manufacturer_id;
    private int ware_type_id;

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public String getWare_type() {
        return ware_type;
    }

    public void setWare_type(String ware_type) {
        this.ware_type = ware_type;
    }

    private String manufacturer_name;
    private String ware_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWare_name() {
        return ware_name;
    }

    public void setWare_name(String ware_name) {
        this.ware_name = ware_name;
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public int getWare_type_id() {
        return ware_type_id;
    }

    public void setWare_type_id(int ware_type_id) {
        this.ware_type_id = ware_type_id;
    }
}
