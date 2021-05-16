package com.caramelpanda.driversapp.data.api;

import java.io.Serializable;

public class Driver implements Serializable {
    private int id;
    private int user;
    private int institutie;
    private boolean disponibil;

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public int getInstitutie() {
        return institutie;
    }

    public boolean isDisponibil() {
        return disponibil;
    }
}