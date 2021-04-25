package com.company.services;

import com.company.classes.City;
import com.company.classes.Delivery;
import com.company.classes.Location;
import com.company.classes.User;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class DeliveryService {
    ArrayList<Delivery> deliveryGuys;

    public DeliveryService() {
        deliveryGuys = new ArrayList<Delivery>();
    }

    public void addDelivery(Delivery d) {
        deliveryGuys.add(d);
    }

    public Delivery getDeliveryGuy(String phonenumber) {
        for(Delivery d : deliveryGuys) {
            if(d.getPhone().equals(phonenumber)) {
                return d;
            }
        }
        return null;
    }

    public ArrayList<Delivery> getDeliveryGuys() {
        return deliveryGuys;
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
                String[] delivery_info = line.split("[\\s]*,[\\s]*");
                String name = delivery_info[0];
                String surname = delivery_info[1];
                String phone_number = delivery_info[2];
                Delivery.Vehicle vehicle;

                switch (delivery_info[3]) {
                    case "Bike":
                        vehicle = Delivery.Vehicle.Bike;
                        break;
                    case "ByFoot":
                        vehicle = Delivery.Vehicle.ByFoot;
                        break;
                    case "Car":
                        vehicle = Delivery.Vehicle.Car;
                        break;
                    default:
                        vehicle = Delivery.Vehicle.Car;
                        break;
                }
                Delivery delivery_guy = new Delivery(name, surname, phone_number, vehicle);

                this.addDelivery(delivery_guy);

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String path, Delivery delivery_guy) {
        File file = new File(path);
        FileWriter writer;
        try {
            file.createNewFile();
            writer = new FileWriter(path, true);

            String formated_text =
                    delivery_guy.getName() + ", "
                  + delivery_guy.getSurname() + ", "
                  + delivery_guy.getPhone() + ", "
                  + delivery_guy.getVehicle();

            writer.write('\n' + formated_text);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
