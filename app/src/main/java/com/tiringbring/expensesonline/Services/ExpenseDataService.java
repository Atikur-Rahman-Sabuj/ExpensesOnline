package com.tiringbring.expensesonline.Services;

import com.tiringbring.expensesonline.Models.Expense;
import com.tiringbring.expensesonline.Models.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ExpenseDataService {
    public Expense SaveExpense(Expense expense){
        Call<Expense> call = new AccessAPI().expenseOnlineAPI.saveExpense(expense);
        try {
            Response<Expense> response = call.execute();
            Expense savedExpense = response.body();
            return savedExpense;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Expense UpdateExpense(Expense expense){
        Call<Expense> call = new AccessAPI().expenseOnlineAPI.updateExpense(expense);
        try {
            Response<Expense> response = call.execute();
            Expense savedExpense = response.body();
            return savedExpense;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
