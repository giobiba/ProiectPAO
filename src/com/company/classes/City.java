package com.company.classes;

import java.util.Objects;
import java.util.UUID;

public class City {
    private final UUID cityId = UUID.randomUUID();
    private String name;
    private String county;

    public City(String name, String county) {
        this.name = name;
        this.county = county;
    }

    public UUID getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}