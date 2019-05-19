package com.assignment.models.DB_Models;

public class Ware {
    private int id;
    private String ware_name;
    private int manufacturer_id;
    private int ware_type_id;

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
