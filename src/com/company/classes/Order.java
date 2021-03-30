package com.company.classes;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public abstract class Order {
    private final UUID orderId = UUID.randomUUID();
    private Date date;
    private Locale locale;
    private User client;
    private Delivery delivery;
    private float price;
    private String[] order;
    private boolean completed;

    public Order(Locale locale, User client, Delivery delivery, float price, String[] order, boolean completed) {
        this.date = new Date(System.currentTimeMillis());
        this.locale = locale;
        this.client = client;
        this.delivery = delivery;
        this.price = price;
        this.order = order;
        this.completed = completed;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String[] getOrder() {
        return order;
    }

    public void setOrder(String[] order) {
        this.order = order;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", locale=" + locale +
                ", client=" + client +
                ", delivery=" + delivery +
                ", price=" + price +
                ", order=" + Arrays.toString(order) +
                ", completed=" + completed +
                '}';
    }
}
