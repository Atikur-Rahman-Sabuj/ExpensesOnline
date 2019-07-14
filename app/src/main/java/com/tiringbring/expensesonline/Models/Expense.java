package com.tiringbring.expensesonline.Models;

import java.util.Date;

public class Expense extends RootModel implements Comparable<Expense>{
    public String name;
    public Date date;
    public double amount;
    public String user_id;

    public Expense(String name, Date date, double amount, String user_id) {
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

    @Override
    public int compareTo(Expense o) {
        return  getDate().compareTo(o.getDate());
    }
}
