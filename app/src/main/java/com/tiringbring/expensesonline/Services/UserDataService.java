package com.tiringbring.expensesonline.Services;

import android.widget.TextView;

import com.tiringbring.expensesonline.Models.User;
import com.tiringbring.expensesonline.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class UserDataService {
    public User RegisterUser(User user){
        Call<User> call = new AccessAPI().expenseOnlineAPI.registerUser(user);
        try {
            Response<User> response = call.execute();
            User registeredUser = response.body();
            return registeredUser;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User LoginUser(String email, String password){
        Call<User> call = new AccessAPI().expenseOnlineAPI.loginUser(email, password);
        try {
            Response<User> response = call.execute();
            if(response.code()==202){
                //user not found
                return null;
            }
            else if(response.code()== 204){
                //wrong password
                return null;
            }
            else if(response.code() == 200) {
                //logged in successful
                User loggedinUser = response.body();
                return loggedinUser;
            }else{
                //unknown
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User activateUser(String _id, String code){
        Call<User> call = new AccessAPI().expenseOnlineAPI.activateUser(_id, code);
        try {
            Response<User> response = call.execute();
            if(response.code()==201){
                //did not match code
                return null;
            }
            else if(response.code() == 200) {
                //logged in successful
                User loggedinUser = response.body();
                return loggedinUser;
            }else{
                //unknown
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public interface UserDataServiceInteractionListener {
        // TODO: Update argument type and name
        void Registration();

        void Login();
    }
}
