package com.caramelpanda.driversapp.data;

import com.caramelpanda.driversapp.data.api.Driver;
import com.caramelpanda.driversapp.data.api.Institution;
import com.caramelpanda.driversapp.data.api.Matching;
import com.caramelpanda.driversapp.data.api.User;

import java.io.Serializable;

public class Account implements Serializable {

    private User user;
    private Institution institution;
    private Driver driver;
    private Matching matching;

    private boolean working;

    public Account(User user, Driver driver, Institution institution) {
        this.user = user;
        this.institution = institution;
        this.driver = driver;
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

    public Matching getMatching() {
        return matching;
    }

    public void setMatching(Matching matching) {
        this.matching = matching;
        working = true;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
