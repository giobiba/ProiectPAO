package com.company.classes;

import java.util.Objects;
import java.util.UUID;

public class Locale {
    private UUID localeId = UUID.randomUUID();
    private String name;
    private Location location;
    private String[] menu;

    private int openhour;
    private int closehour;

    public Locale(String name, Location location, String[] menu, int openhour, int closehour) {
        this.name = name;
        this.location = location;
        this.menu = menu;
        this.openhour = openhour;
        this.closehour = closehour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String[] getMenu() {
        return menu;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public int getOpenhour() {
        return openhour;
    }

    public void setOpenhour(int openhour) {
        this.openhour = openhour;
    }

    public int getClosehour() {
        return closehour;
    }

    public void setClosehour(int closehour) {
        this.closehour = closehour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}