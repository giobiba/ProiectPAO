package com.company.classes;

import java.util.UUID;

public class Location {
    private Integer location_id;
    private String street;
    private int number;
    private City city;

    public Location(Integer location_id, String street, int number, City city) {
        this.location_id = location_id;
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public Location(Location address) {
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = new City(address.city);
    }

    public Integer getLocationId() {
        return location_id;
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