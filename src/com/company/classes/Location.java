package com.company.classes;

import java.util.UUID;

public class Location {
    private final UUID locationId = UUID.randomUUID();
    private String street;
    private int number;
    private City city;

    public Location(String street, int number, City city) {
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", city=" + city +
                '}';
    }
}