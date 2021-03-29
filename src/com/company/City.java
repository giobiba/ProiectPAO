package com.company;

public class City {
    String nume;
    String judet;

    public City(String nume, String judet) {
        this.nume = nume;
        this.judet = judet;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }
}