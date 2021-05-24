package com.company.services;

import com.company.DatabaseManager;
import com.company.classes.City;
import com.company.classes.Locale;
import com.company.classes.Location;
import com.company.classes.User;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

public class LocaleService {
    ArrayList<Locale> locales = new ArrayList<Locale>();

    public ArrayList<Locale> availableLocales(User u) throws SQLException{
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

    public String[] getMenu(Integer locale_id, DatabaseManager db) throws SQLException {
        Statement stmt = db.conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT NAME FROM MENU WHERE LOCALE_ID == " + locale_id);
        ArrayList<String> menu = new ArrayList<>();
        while(res.next()) {
            String item = res.getString("name");
            menu.add(item);
        }
        return menu.toArray(new String[0]);
    }

    public Locale getLocaleByName(String name) {
        for(Locale l : locales) {
            if(l.getName().equals(name)) {
                return l;
            }
        }
        return null;
    }

    public void addToMenu(String item, Integer locale_id) {
        for(Locale l : locales) {
            if(l.getLocaleId().equals(locale_id)) {
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

    public void readFromFile(String path, DatabaseManager db) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader((
                    Objects.requireNonNull(this.getClass().getResourceAsStream("/" + path))
            )));

            Statement stmt = db.conn.createStatement();
            String line = reader.readLine();

            while(line != null) {
                if (line.equals("")) {
                    line = reader.readLine();
                    continue;
                }
                String[] locale_info = line.split("[\\s]*,[\\s]*");
                Integer locale_id = Integer.parseInt(locale_info[0]);
                String locale_name = locale_info[1];

                Integer location_id =  Integer.parseInt(locale_info[2]);
                Location address = new Location(100, "dfsa", 13, new City(100, "dsadq", "100"));

                String[] menu = locale_info[3].substring(1, locale_info[3].length() - 1).split("[\\s]*;[\\s]*");

                Stream.of(menu).forEach(item -> {
                    try {
                        String sql = "INSERT INTO MENU(name, price, locale_id) VALUES(?,?,?)";
                        PreparedStatement pstmt = db.conn.prepareStatement(sql);

                        pstmt.setString(1, item);
                        pstmt.setInt(2, 1);
                        pstmt.setInt(3, locale_id);
                        pstmt.executeUpdate();


                        pstmt.execute();

                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

                int open_hour = Integer.parseInt(locale_info[4]);
                int close_hour = Integer.parseInt(locale_info[5]);

                String sql = "INSERT INTO LOCALES(locale_id, name, location_id, open_hour, close_hour) VALUES(?,?,?,?,?)";

                PreparedStatement pstmt = db.conn.prepareStatement(sql);
                pstmt.setInt(1,locale_id);
                pstmt.setString(2,locale_name);
                pstmt.setInt(3, location_id);
                pstmt.setInt(4, open_hour);
                pstmt.setInt(5, close_hour);

                pstmt.executeUpdate();

                Locale locale = new Locale(locale_id, locale_name, address, menu, open_hour, close_hour);
                locales.add(locale);

                line = reader.readLine();
            }
        }catch (IOException | SQLException e) {
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
