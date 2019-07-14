package com.tiringbring.expensesonline.DataAccess;

import android.widget.TextView;

import com.tiringbring.expensesonline.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Test {


    public List<Post> GetData(TextView txtViewResult){
        Call<List<Post>> call = new AccessAPI().expenseOnlineAPI.getPost();

        try {
            Response<List<Post>> response = call.execute();
            List<Post> posts = response.body();
            return posts;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Post>();
        }

    }
}
