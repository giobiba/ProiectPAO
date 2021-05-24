package com.company.classes;

import java.util.UUID;

public class Delivery {

    public enum Vehicle {
        Bike,
        Car,
        ByFoot
    }

    private Integer deliveryId;
    private String name;
    private String surname;
    private String phone;
    private Vehicle vehicle;

    public Delivery(String name, String surname, String phone, Vehicle vehicle) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.vehicle = vehicle;
    }

    public Delivery(Integer deliveryId, String name, String surname, String phone, Vehicle vehicle) {
        this.deliveryId = deliveryId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.vehicle = vehicle;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}