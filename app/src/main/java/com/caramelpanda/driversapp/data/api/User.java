package com.caramelpanda.driversapp.data.api;

import java.io.Serializable;

public class User implements Serializable {
    private int id; // <- the userid of driver
    private String username; // <- the user
    private String email; // <- The email
    private String password; // <- The password
    private String first_name; // <- first name
    private String last_name; // <- last name

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

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }
}
