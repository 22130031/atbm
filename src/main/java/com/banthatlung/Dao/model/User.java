package com.banthatlung.Dao.model;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private String id;
    private String username;
    private String pass;
    private int role;
    private String name;
    private String email;
    private String phone;
    private Date birthday;
    private String gender;
    private String image;

    public String getId() {
        return id;
    }

    public User(){

    }

    public User(String id, String username, String pass, int role, String name, String email, String phone, Date birthday, String gender, String image) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }
}