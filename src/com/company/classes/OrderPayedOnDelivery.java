package com.company.classes;

import java.util.Date;

public class OrderPayedOnDelivery extends Order{
    private boolean hasChange;

    public OrderPayedOnDelivery(Locale locale, User client, Delivery delivery, float price, String[] order, boolean completed, boolean hasChange) {
        super(locale, client, delivery, price, order, completed);
        this.hasChange = hasChange;
    }

    public boolean getHasChange() {
        return hasChange;
    }

    public void setHasChange(boolean hasChange) {
        this.hasChange = hasChange;
    }
}
