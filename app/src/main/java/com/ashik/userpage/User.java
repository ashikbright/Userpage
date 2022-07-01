package com.ashik.userpage;

public class User {

    public String name, email, phone, isUser;

    public User() {
    }

    public User(String name, String email, String phone, String isUser) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isUser = isUser;
    }


    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] GenerateData(String name, String email, String phone){
        String[] data = {
                name, email, phone, "", ""
        };


        return data;
    }

}
