package com.caramelpanda.driversapp.data;

public class Account {

    private String user;
    private String pass;
    private String institutionName;

    // Will be added later

//    private final String firstName;
//    private final String secondName;

    public Account(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
