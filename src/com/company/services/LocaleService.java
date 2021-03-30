package com.company.services;

import com.company.classes.City;
import com.company.classes.Locale;
import com.company.classes.User;

import java.util.ArrayList;
import java.util.UUID;

public class LocaleService {
    ArrayList<Locale> locales;

    public LocaleService() {
        this.locales = new ArrayList<Locale>();
    }

    public ArrayList<Locale> availableLocales(User u) {
        if(u == null)
            return null;

        ArrayList<Locale> av = new ArrayList<Locale>();

        City currentCity = u.getAddress().getCity();

        for(Locale l : locales) {
            if(currentCity.equals(l.getLocation().getCity())) {
                av.add(l);
            }
        }
        return av;
    }

    public String[] getMenu(UUID localeId) {
        for(Locale l : locales) {
            if(l.getLocaleId() == localeId) {
                return l.getMenu();
            }
        }
        return null;
    }

    public void addToMenu(String item, UUID localeId) {
        for(Locale l : locales) {
            if(l.getLocaleId() == localeId) {
                l.modifyMenu(item);
                return;
            }
        }
    }

    public ArrayList<Locale> getLocales() {
        return locales;
    }

    public void addLocale(Locale l) {
        locales.add(l);
    }
}
