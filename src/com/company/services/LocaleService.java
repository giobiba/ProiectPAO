package com.company.services;

import com.company.classes.*;
import com.company.classes.Locale;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public Locale getLocaleByName(String name) {
        for(Locale l : locales) {
            if(l.getName().equals(name)) {
                return l;
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

    public void sortLocales() {
        locales.sort(Comparator.comparing((Locale l) -> l.getLocation().getCity()));
    }

    public void printLocales() {
        locales.forEach(System.out::println);
    }

    public ArrayList<Locale> getLocales() {
        return locales;
    }

    public void addLocale(Locale l) {
        locales.add(l);
    }

    public void readFromFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line = reader.readLine();

            while(line != null) {
                if (line.equals("")) {
                    line = reader.readLine();
                    continue;
                }
                String[] locale_info = line.split("[\\s]*,[\\s]*");
                String locale_name = locale_info[0];

                String street_name =  locale_info[1];
                int street_number = Integer.parseInt(locale_info[2]);

                String city_name = locale_info[3];
                String county_name = locale_info[4];

                City city = new City(city_name, county_name);

                Location address = new Location(street_name, street_number, city);

                String[] menu = locale_info[5].substring(1, locale_info[5].length() - 1).split("[\\s]*;[\\s]*");

                int open_hour = Integer.parseInt(locale_info[6]);
                int close_hour = Integer.parseInt(locale_info[7]);

                Locale l = new Locale(locale_name, address, menu, open_hour, close_hour);

                this.addLocale(l);

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String path, Locale locale) {
        File file = new File(path);
        FileWriter writer;
        try {
            file.createNewFile();
            writer = new FileWriter(path, true);

            String formated_text =
                      locale.getName() + ", "
                    + locale.getLocation().getStreet() + ", "
                    + locale.getLocation().getNumber() + ", "
                    + locale.getLocation().getCity().getName() + ", "
                    + locale.getLocation().getCity().getCounty() + ", "
                    + locale.getOpenhour() + ", "
                    + locale.getClosehour() + ", ";

            writer.write('\n' + formated_text);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
