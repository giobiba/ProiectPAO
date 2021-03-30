package com.company.services;

import com.company.classes.Delivery;

import java.util.ArrayList;
import java.util.UUID;

public class DeliveryService {
    ArrayList<Delivery> deliveryGuys;

    public DeliveryService() {
        deliveryGuys = new ArrayList<Delivery>();
    }

    public void addDelivery(Delivery d) {
        deliveryGuys.add(d);
    }

    public Delivery getDeliveryGuy(UUID deliveryId) {
        for(Delivery d : deliveryGuys) {
            if(d.getDeliveryId() == deliveryId) {
                return d;
            }
        }
        return null;
    }

    public ArrayList<Delivery> getDeliveryGuys() {
        return deliveryGuys;
    }
}
