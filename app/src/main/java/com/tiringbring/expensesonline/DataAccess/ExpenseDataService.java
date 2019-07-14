package com.tiringbring.expensesonline.DataAccess;

import com.tiringbring.expensesonline.Models.Expense;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Expense> GetExpensesofUser(String user_id){
        Call<List<Expense>> call = new AccessAPI().expenseOnlineAPI.getExpensesofUser(user_id);
        try {
            Response<List<Expense>> response = call.execute();
            List<Expense> expenses = response.body();
            return  expenses;
        } catch (IOException e) {
            return new ArrayList<Expense>();
        }
    }
}
