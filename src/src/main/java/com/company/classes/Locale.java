package com.company.classes;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Locale {
    private Integer locale_id;
    private String name;
    private Location location;
    private String[] menu;

    private int openhour;
    private int closehour;

    public Locale(Integer locale_id, String name, Location location, String[] menu, int openhour, int closehour) {
        this.locale_id = locale_id;
        this.name = name;
        this.location = location;
        this.menu = menu;
        this.openhour = openhour;
        this.closehour = closehour;
    }

    public Integer getLocaleId() {
        return locale_id;
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

    public void modifyMenu(String item) {
        int N = this.menu.length;
        this.menu = Arrays.copyOf(this.menu, N + 1);
        this.menu[N] = item;
    }

    @Override
    public String toString() {
        return "Locale{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", menu=" + Arrays.toString(menu) +
                ", openhour=" + openhour +
                ", closehour=" + closehour +
                '}';
    }
}