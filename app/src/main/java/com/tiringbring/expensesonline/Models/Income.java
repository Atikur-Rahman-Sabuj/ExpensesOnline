package com.tiringbring.expensesonline.Models;

import java.util.Date;

public class Income {
    public String name;
    public Date date;
    public double amount;
    public String user_id;

    public Income(String name, Date date, double amount, String user_id) {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getUser_id() {
        return user_id;
    }
}
