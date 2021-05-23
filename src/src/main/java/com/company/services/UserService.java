package com.company.services;

import com.company.classes.City;
import com.company.classes.Location;
import com.company.classes.User;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserService {
    private ArrayList<User> users;

    public UserService() {
        this.users = new ArrayList<User>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public UserService(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public void readFromFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader((
                    this.getClass().getResourceAsStream("/" + path)
                    )));

            String line = reader.readLine();

            while(line != null) {
                if (line.equals("")) {
                    line = reader.readLine();
                    continue;
                }
                String[] user_info = line.split("[\\s]*,[\\s]*");
                String name = user_info[0];
                String surname = user_info[1];
                String phone = user_info[2];
                
                String street_name =  user_info[3];
                Integer street_number = Integer.valueOf(user_info[4]);

                String city_name = user_info[5];
                String county_name = user_info[6];

                City city = new City(city_name, county_name);

                Location address = new Location(street_name, street_number, city);

                String email = user_info[7];

                DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                Date date = format.parse(user_info[8]);

                User user = new User(name, surname, phone, address, email, date);

                users.add(user);

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

    public void writeToFile(String path, User user) {
        File file = new File(path);
        FileWriter writer;
        try {
            file.createNewFile();
            writer = new FileWriter(path, true);

            String formated_text = String.format(user.getName() + ", "
                    + user.getSurname() + ", "
                    + user.getPhone() + ", "
                    + user.getAddress().getStreet() + ", "
                    + user.getAddress().getNumber() + ", "
                    + user.getAddress().getCity().getName() + ", "
                    + user.getAddress().getCity().getCounty() + ", "
                    + user.getEmail() + ", "
                    + new SimpleDateFormat("dd.MM.yyyy").format(user.getBirthday()));

            writer.write('\n' + formated_text);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public User findByMail(String mail) {
        for(User user : users) {
            if(mail.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }
}
