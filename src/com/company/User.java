package com.company;

import java.util.Date;
import java.util.Objects;

public class User {
    private String nume;
    private String prenume;

    private String telefon;
    private Location adresa;
    private String mail;

    private Date data_nasterii;

    public User(String nume, String prenume, String telefon, Location adresa, String mail, Date data_nasterii) {
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.mail = mail;
        this.data_nasterii = data_nasterii;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Location getAdresa() {
        return adresa;
    }

    public void setAdresa(Location adresa) {
        this.adresa = adresa;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, telefon, mail);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final User other = (User) obj;

        return Objects.equals(this.nume, other.nume) && Objects.equals(this.prenume, other.prenume) && Objects.equals(this.telefon, other.telefon) && Objects.equals(this.mail, other.mail);
    }
}