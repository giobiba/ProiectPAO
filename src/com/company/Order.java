package com.company;

import java.util.Date;
import java.util.Objects;

public abstract class Order {
    private Date data;
    private Locale local;
    private User client;
    private Delivery curier;
    private float pret;
    private String[] comanda;

    public Order(Date data, Locale local, User client, Delivery curier, float pret, String[] comanda) {
        this.data = data;
        this.local = local;
        this.client = client;
        this.curier = curier;
        this.pret = pret;
        this.comanda = comanda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Locale getLocal() {
        return local;
    }

    public void setLocal(Locale local) {
        this.local = local;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Delivery getCurier() {
        return curier;
    }

    public void setCurier(Delivery curier) {
        this.curier = curier;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String[] getComanda() {
        return comanda;
    }

    public void setComanda(String[] comanda) {
        this.comanda = comanda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(curier, client, data, local, comanda, pret);
    }
}
