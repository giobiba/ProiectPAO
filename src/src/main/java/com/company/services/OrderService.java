package com.company.services;

import com.company.classes.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class OrderService {
    ArrayList<Order> orders;
    FileWriter logger;

    public OrderService(String log_path) {
        this.orders = new ArrayList<Order>();
        try {
            File file = new File(log_path);
            file.createNewFile();
            this.logger = new FileWriter(file, true);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
    public void completeOrder(UUID idOrder) {

        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                o.setCompleted(true);
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    logger.write(dtf.format(LocalDateTime.now()) + " Completed order with id " + o.getOrderId() + "\n");
                }
                catch(IOException e) {
                    System.out.println("Couldnt write to file!");
                }
                return;
            }
        }
    }

    public Order getOrder(UUID idOrder) {
        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    logger.write(dtf.format(LocalDateTime.now()) + " Got order with id " + o.getOrderId() + "\n");
                }
                catch(IOException e) {
                    System.out.println("Couldnt write to file!");
                }

                return o;
            }
        }
        return null;
    }

    public void addOrder(Order  other) {
        orders.add(other);

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            logger.write(dtf.format(LocalDateTime.now()) + " Added order with id " + other.getOrderId() + "\n");
        }
        catch(IOException e) {
            System.out.println("Couldnt write to file!");
        }
    }

    public void cancelOrder(UUID idOrder) {
        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                orders.remove(o);
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    logger.write(dtf.format(LocalDateTime.now()) + " Cancelled order with id " + o.getOrderId() + "\n");
                }
                catch(IOException e) {
                    System.out.println("Couldnt write to file!");
                }
                return;
            }
        }
    }

    public void changeDelivery(Delivery d, UUID idOrder) {
        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                o.setDelivery(d);
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    logger.write(dtf.format(LocalDateTime.now()) + " Changed order's (" + o.getOrderId() +") delivery" +
                            " guy (" + d.getDeliveryId() +") \n");
                }
                catch(IOException e) {
                    System.out.println("Couldnt write to file!");
                }
                return;
            }
        }
    }

    public ArrayList<Order> showHistory(User u) {
        ArrayList<Order> userOrders = new ArrayList<Order>();

        for(Order order : orders) {
            if(u.equals(order.getClient())) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

//    public void readFromFile(String path, UserService us, LocaleService ls, DeliveryService ds) {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader((
//                    this.getClass().getResourceAsStream("/" + path)
//            )));
//
//            String line = reader.readLine();
//
//            while(line != null) {
//                if (line.equals("")) {
//                    line = reader.readLine();
//                    continue;
//                }
//
//                String[] order_info = line.split("[\\s]*,[\\s]*");
//
//                Locale locale = ls.getLocaleByName(order_info[0]);
//                User user = us.findByMail(order_info[1]);
//                Delivery delivery = ds.getDeliveryGuy(order_info[2]);
//                Float price = Float.valueOf(order_info[3]);
//                String[] order = order_info[4].substring(1, order_info[4].length() - 1).split("[\\s]*;[\\s]*");
//
//                Boolean completed;
//                switch (order_info[5]) {
//                    case "true":
//                        completed = true;
//                        break;
//                    default:
//                        completed = false;
//                        break;
//                }
//
//                // cazul orderPayedOnDelivery
//                if (order_info.length == 7) {
//                    Boolean hasChange;
//                    switch (order_info[6]) {
//                        case "true":
//                            hasChange = true;
//                            break;
//                        default:
//                            hasChange = false;
//                            break;
//                    }
//                    this.addOrder(new OrdersPayedOnDelivery(locale, user, delivery, price, order, completed,
//                            hasChange));
//                }
//                // cazul orderPayedOnline
//                else {
//                    String card = order_info[6];
//                    String card_holder = order_info[7];
//
//                    this.addOrder(new OrdersPayedOnline(locale, user, delivery, price, order, completed, card,
//                            card_holder));
//                }
//
//                line = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void writeToFile(String path, Order order) {
        File file = new File(path);
        FileWriter writer;
        try {
            file.createNewFile();
            writer = new FileWriter(path, true);

            StringBuilder o = new StringBuilder("(");

            for(var or : order.getOrder()) {
                o.append(or).append(", ");
            }
            o = new StringBuilder(o.substring(0, o.length() - 2) + ")");

            String formated_text = order.getLocale().getName() + ", "
                    + order.getClient().getEmail() + ", "
                    + order.getDelivery().getPhone() + ", "
                    + order.getPrice() + ", "
                    + o + ", "
                    + order.isCompleted() + ", ";

            if(order instanceof OrdersPayedOnDelivery)
                formated_text = formated_text
                        + ((OrdersPayedOnDelivery) order).getHasChange();

            if(order instanceof OrdersPayedOnline)
                formated_text = formated_text
                        + ((OrdersPayedOnline) order).getCardNumber() + ", "
                        + ((OrdersPayedOnline) order).getCardHolder();

            writer.write('\n' + formated_text);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
