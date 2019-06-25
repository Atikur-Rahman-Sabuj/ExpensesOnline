package com.tiringbring.expensesonline.Services;

import com.tiringbring.expensesonline.JsonPlaceHolderApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccessAPI {
    Retrofit retrofit;
    ExpenseOnlineAPI expenseOnlineAPI;

    public AccessAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.102:3001/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        expenseOnlineAPI = retrofit.create(ExpenseOnlineAPI.class);
    }
}
