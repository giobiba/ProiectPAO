package com.company;

import java.util.Date;

public class OrdersPayedOnline extends Order{
    private String numar_card;
    private String detinator;

    public OrdersPayedOnline(Date data, Locale local, User client, Delivery curier, float pret, String[] comanda, String numar_card, String detinator) {
        super(data, local, client, curier, pret, comanda);
        this.numar_card = numar_card;
        this.detinator = detinator;
    }

    public String getNumar_card() {
        return numar_card;
    }

    public void setNumar_card(String numar_card) {
        this.numar_card = numar_card;
    }

    public String getDetinator() {
        return detinator;
    }

    public void setDetinator(String detinator) {
        this.detinator = detinator;
    }
}
