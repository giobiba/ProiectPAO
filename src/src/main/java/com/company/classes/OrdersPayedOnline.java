package com.company.classes;

import java.util.Date;

public class OrdersPayedOnline extends Order{
    private String cardNumber;
    private String cardHolder;

    public OrdersPayedOnline(Locale locale, User client, Delivery delivery, float price, String[] order, boolean completed, String cardNumber, String cardHolder) {
        super(locale, client, delivery, price, order, completed);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
}
