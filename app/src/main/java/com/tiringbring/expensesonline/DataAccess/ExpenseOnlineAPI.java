package com.tiringbring.expensesonline.DataAccess;

import com.tiringbring.expensesonline.Models.Expense;
import com.tiringbring.expensesonline.Models.User;
import com.tiringbring.expensesonline.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ExpenseOnlineAPI {
    //user
    @GET("test")
    Call<List<Post>> getPost();
    @GET("user/login")
    Call<User> loginUser(@Query("email") String email, @Query("password") String password);
    @POST("user/register")
    Call<User> registerUser(@Body User user);
    @POST("user/verifyemail")
    Call<User> activateUser(@Query("_id") String _id, @Query("code") String code);

    //expense
    @POST("expense")
    Call<Expense> saveExpense(@Body Expense expense);
    @POST("expense/update")
    Call<Expense> updateExpense(@Body Expense expense);
    @GET("expense")
    Call<List<Expense>> getExpensesofUser(@Query("user_id") String user_id);
    //income
}
