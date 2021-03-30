package com.company;

import com.company.classes.*;
import com.company.services.DeliveryService;
import com.company.services.LocaleService;
import com.company.services.OrderService;
import com.company.services.UserService;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        LocaleService ls = new LocaleService();
        DeliveryService ds = new DeliveryService();
        OrderService os = new OrderService();
        UserService us = new UserService();

        City bucuresti = new City("Bucuresti", "Bucuresti");
        City braila = new City("Braila", "Braila");
        City galati = new City("Galati", "Galati");

        Locale l1 = new Locale("Pui la Babes", new Location("Brailei", 3, galati), (new String[]{"Paine", "Shaorma", "Mici"}), 8,20);
        Locale l2 = new Locale("Mcdonalds", new Location("Calea Galati", 10, braila), (new String[]{"Combo", "Mcchicken", "Nuggets"}), 5, 22);
        Locale l3 = new Locale("Shaorma la micutzu", new Location("Victoriei", 29, bucuresti),(new String[]{"Shaorma mica", "Shaorma mare"}), 7, 19);
        Locale l4 = new Locale("KFC", new Location("Bulevardul Unirii", 102, bucuresti), (new String[]{"Ciorba de perisoare", "Mamaliga cu ciumala"}), 9, 23);

        User u1 = new User("Hohenzollern", "Ferdinand", "0722222222", new Location("Mihai Bravu", 17, bucuresti), "ferdinand@gmail.com", new Date(1999, Calendar.NOVEMBER, 18));
        User u2 = new User("Grasu", "Alberto", "0712345678", new Location("Ferdinand I", 2, galati), "albgrasu@gmail.com", new Date(2003, Calendar.JANUARY, 3));

        Delivery d1 = new Delivery("Mihaita", "Piticu", "0712309723", Delivery.Vehicle.Bike);
        Delivery d2 = new Delivery("Bucharest", "Bike Traffic", "072136623", Delivery.Vehicle.ByFoot);

        ls.addLocale(l1);
        ls.addLocale(l2);
        ls.addLocale(l3);
        ls.addLocale(l4);

        ds.addDelivery(d1);
        ds.addDelivery(d2);

        us.addUser(u1);
        us.addUser(u2);

        Locale l5 = ls.availableLocales(u1).get(0);
        Locale l6 = ls.availableLocales(u2).get(0);

        Order o = new OrdersPayedOnline(l5, u1, d1, 30, l5.getMenu(), "1111 1111 1111 1111", false, "Mama" );

        os.addOrder(o);
        os.changeDelivery(d2, o.getOrderId());
        os.completeOrder(o.getOrderId());

        System.out.println(os.getOrder(o.getOrderId()).toString());

        Order o2 =  new OrdersPayedOnline(l6, u2, d2, 60, l6.getMenu(), "2222 1111 1111 3333", false, "Tata" );
        os.addOrder(o2);
        os.cancelOrder(o2.getOrderId());

        System.out.println(os.showHistory(u1).toString());

        ls.addToMenu("pizza", l3.getLocaleId());
    }
}
