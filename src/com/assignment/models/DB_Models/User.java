package com.assignment.models.DB_Models;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String postal_code;
    private String city;
    private String street;
    private String street_number;

    public User(String username, String password, String email, String first_name, String last_name, String postal_code, String city, String street, String street_number) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.postal_code = postal_code;
        this.city = city;
        this.street = street;
        this.street_number = street_number;
    }

    public User(int id, String username, String password, String email, String first_name, String last_name, String postal_code, String city, String street, String street_number) {
        this(username, password, email, first_name, last_name, postal_code, city, street, street_number);
        this.id = id;
    }
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }
}
