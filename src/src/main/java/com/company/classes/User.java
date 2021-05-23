package com.company.classes;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID userId = UUID.randomUUID();
    private String name;
    private String surname;

    private String phone;
    private Location address;
    private String email;

    private Date birthday;

    public User(String name, String surname, String phone, Location address, String email, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = new Location(address);
        this.email = email;
        this.birthday = birthday;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

        public void setName(String name) {
            this.name = name;
        }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}