package com.company.services;

import com.company.classes.Delivery;
import com.company.classes.Order;
import com.company.classes.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class OrderService {
    ArrayList<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<Order>();
    }

    public void completeOrder(UUID idOrder) {
        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                o.setCompleted(true);
            }
        }
    }

    public Order getOrder(UUID idOrder) {
        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                return o;
            }
        }
        return null;
    }

    public void addOrder(Order  other) {
        orders.add(other);
    }

    public void cancelOrder(UUID idOrder) {
        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                orders.remove(o);
                break;
            }
        }
    }

    public void changeDelivery(Delivery d, UUID idOrder) {
        for(Order o : orders) {
            if(o.getOrderId() == idOrder) {
                o.setDelivery(d);
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
}
