package com.company;

import com.company.classes.*;
import com.company.services.DeliveryService;
import com.company.services.LocaleService;
import com.company.services.OrderService;
import com.company.services.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        LocaleService ls = new LocaleService();
        DeliveryService ds = new DeliveryService();
        OrderService os = new OrderService("src/com/company/csvs/log-orders.csv");
        UserService us = new UserService();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        us.readFromFile("src/com/company/csvs/users.csv");
        ds.readFromFile("src/com/company/csvs/deliveries.csv");
        ls.readFromFile("src/com/company/csvs/locales.csv");
        ls.sortLocales();
        os.readFromFile("src/com/company/csvs/orders.csv", us, ls, ds);

        ls.writeToFile("src/com/company/csvs/locales.csv", ls.getLocales().get(0));
    }
}
