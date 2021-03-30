package com.company;

import java.util.Date;

public class OrderPayedOnDelivery extends Order{
    private Boolean areMarunt;

    public OrderPayedOnDelivery(Date data, Locale local, User client, Delivery curier, float pret, String[] comanda, Boolean areMarunt) {
        super(data, local, client, curier, pret, comanda);
        this.areMarunt = areMarunt;
    }

    public Boolean getAreMarunt() {
        return areMarunt;
    }

    public void setAreMarunt(Boolean areMarunt) {
        this.areMarunt = areMarunt;
    }
}
