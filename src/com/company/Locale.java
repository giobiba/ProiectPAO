package com.company;

public class Locale {
    String nume;
    Location locatie;
    String[] meniu;
    String[] promotii;

    int oraDeschidere;
    int oraInchidere;

    public Locale(String nume, Location locatie, String[] meniu, String[] promotii, int oraDeschidere, int oraInchidere) {
        this.nume = nume;
        this.locatie = locatie;
        this.meniu = meniu;
        this.promotii = promotii;
        this.oraDeschidere = oraDeschidere;
        this.oraInchidere = oraInchidere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Location getLocatie() {
        return locatie;
    }

    public void setLocatie(Location locatie) {
        this.locatie = locatie;
    }

    public String[] getMeniu() {
        return meniu;
    }

    public void setMeniu(String[] meniu) {
        this.meniu = meniu;
    }

    public String[] getPromotii() {
        return promotii;
    }

    public void setPromotii(String[] promotii) {
        this.promotii = promotii;
    }

    public int getOraDeschidere() {
        return oraDeschidere;
    }

    public void setOraDeschidere(int oraDeschidere) {
        this.oraDeschidere = oraDeschidere;
    }

    public int getOraInchidere() {
        return oraInchidere;
    }

    public void setOraInchidere(int oraInchidere) {
        this.oraInchidere = oraInchidere;
    }
}