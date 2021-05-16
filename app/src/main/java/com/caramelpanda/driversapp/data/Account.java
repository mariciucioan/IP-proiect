package com.caramelpanda.driversapp.data;

import com.caramelpanda.driversapp.data.api.Driver;
import com.caramelpanda.driversapp.data.api.Institution;
import com.caramelpanda.driversapp.data.api.User;

import java.io.Serializable;

public class Account implements Serializable {

    private User user;
    private Institution institution;
    private Driver driver;

    public Account(User user, Driver driver, Institution institution) {
        this.user = user;
        this.institution = institution;
    }

    public User getUser() {
        return user;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Driver getDriver() {
        return driver;
    }
}
