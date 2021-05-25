package com.caramelpanda.driversapp.data.api;

public class Matching {

    private int id;
    private int institutie_donatoare;
    private int institutie_primitoare;

    private String data_cerere;
    private String data_plecare_sofer;
    private String data_livrare;

    private int tip_material;
    private int cantitate;
    private int sofer;

    public int getId() {
        return id;
    }

    public int getInstitutie_donatoare() {
        return institutie_donatoare;
    }

    public int getInstitutie_primitoare() {
        return institutie_primitoare;
    }

    public String getData_cerere() {
        return data_cerere;
    }

    public String getData_plecare_sofer() {
        return data_plecare_sofer;
    }

    public String getData_livrare() {
        return data_livrare;
    }

    public int getTip_material() {
        return tip_material;
    }

    public int getCantitate() {
        return cantitate;
    }

    public int getSofer() {
        return sofer;
    }
}
