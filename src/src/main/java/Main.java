import com.company.DatabaseManager;
import com.company.classes.*;
import com.company.services.DeliveryService;
import com.company.services.LocaleService;
import com.company.services.OrderService;
import com.company.services.UserService;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db";
        DatabaseManager db = null;

        try {
            db = new DatabaseManager(url);

            db.initializeDatabase();
        }catch(SQLException e) {
            e.printStackTrace();
        }


        LocaleService ls = new LocaleService();
        DeliveryService ds = new DeliveryService();
        //OrderService os = new OrderService("log-orders.csv");
        UserService us = new UserService();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        us.readFromFile("users.csv", db);
        ds.readFromFile("deliveries.csv", db);
        ls.readFromFile("locales.csv", db);

        try {
            ls.availableLocales(0, db);
        }catch(SQLException e) {
            e.printStackTrace();
        }

        //ls.sortLocales();
        //os.readFromFile("orders.csv", us, ls, ds);

        //ls.writeToFile("locales.csv", ls.getLocales().get(0));

    }
}
