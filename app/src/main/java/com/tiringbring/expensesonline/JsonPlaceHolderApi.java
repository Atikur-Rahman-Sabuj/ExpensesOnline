package com.tiringbring.expensesonline;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("test")
    Call<JsonObject> getPost();
}
