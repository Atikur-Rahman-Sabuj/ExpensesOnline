package com.tiringbring.expensesonline.Models;

public class User extends RootModel {
    public String name;
    public String email;
    public Boolean verified;
    public String password;
    public String code;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getVerified() {
        return verified;
    }
}
