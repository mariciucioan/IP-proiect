package com.caramelpanda.driversapp.data.api;

import com.google.gson.annotations.SerializedName;

public class Institution {
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
