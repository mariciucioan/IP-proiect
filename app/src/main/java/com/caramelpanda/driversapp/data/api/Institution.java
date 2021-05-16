package com.caramelpanda.driversapp.data.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Institution implements Serializable {
    private int id;

    @SerializedName("nume")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
