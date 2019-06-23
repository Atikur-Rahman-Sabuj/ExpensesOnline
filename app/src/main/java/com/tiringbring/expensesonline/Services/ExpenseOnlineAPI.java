package com.tiringbring.expensesonline.Services;

import com.google.gson.JsonObject;
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

    //expense


    //income
}
