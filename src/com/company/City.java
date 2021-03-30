package com.company;

import java.util.Objects;

public class City {
    private String nume;
    private String judet;

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

    @Override
    public int hashCode() {
        return Objects.hash(nume, judet);
    }
}