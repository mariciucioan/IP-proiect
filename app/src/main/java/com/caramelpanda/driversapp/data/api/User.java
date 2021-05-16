package com.caramelpanda.driversapp.data.api;

import java.io.Serializable;

public class User implements Serializable {
    private int id; // <- the userid of driver
    private String username; // <- the user
    private String email; // <- The email
    private String password; // <- The password

    // To add to the api:
    // private String firstName;
    // private String secondName;


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
