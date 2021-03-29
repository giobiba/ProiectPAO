package com.company;

public class Location {
    private String strada;
    private int numar;
    private City oras;

    public Location(String strada, int numar, City oras) {
        this.strada = strada;
        this.numar = numar;
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public City getOras() {
        return oras;
    }

    public void setOras(City oras) {
        this.oras = oras;
    }
}