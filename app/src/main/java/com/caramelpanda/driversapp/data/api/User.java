package com.caramelpanda.driversapp.data.api;

public class User {
    private int id; // <- the userid of driver
    private String username; // <- the user
    private String email; // <- The email

    // To add to the api:
    // private String firstName;
    // private String secondName;
    // private String password;


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
