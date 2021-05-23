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
        OrderService os = new OrderService("log-orders.csv");
        UserService us = new UserService();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        us.readFromFile("users.csv");
        ds.readFromFile("deliveries.csv");
        ls.readFromFile("locales.csv");
        ls.sortLocales();
        os.readFromFile("orders.csv", us, ls, ds);

        ls.writeToFile("locales.csv", ls.getLocales().get(0));
    }
}
