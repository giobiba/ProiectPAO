package com.company.services;

import com.company.classes.User;

import java.util.ArrayList;

public class UserService {
    private ArrayList<User> users;

    public UserService() {
        this.users = new ArrayList<User>();
    }

    public UserService(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User u) {
        users.add(u);
    }
}
