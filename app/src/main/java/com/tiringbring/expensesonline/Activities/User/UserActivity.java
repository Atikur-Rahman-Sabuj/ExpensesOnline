package com.tiringbring.expensesonline.Activities.User;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.tiringbring.expensesonline.Activities.RootActivity;
import com.tiringbring.expensesonline.Fragment.User.ActivationFragment;
import com.tiringbring.expensesonline.Fragment.User.LoginFragment;
import com.tiringbring.expensesonline.Fragment.User.RegisterFragment;
import com.tiringbring.expensesonline.MainActivity;
import com.tiringbring.expensesonline.Models.User;
import com.tiringbring.expensesonline.R;
import com.tiringbring.expensesonline.SharedData.Memory;
import com.tiringbring.expensesonline.SharedData.Preference;

public class UserActivity extends RootActivity implements LoginFragment.OnFragmentInteractionListener, RegisterFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        AddFragment(new LoginFragment());
    }




    private void AddFragment(Fragment fragment){
        if(findViewById(R.id.fragmentFrame)!=null)
        {
            // Bundle bundle = new Bundle();
            // bundle.putInt("Day", Day);
            // bundle.putInt("Month", Month);
            // bundle.putInt("Year", Year);
            // fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentFrame,fragment).commit();
        }
    }

    public void GotToRegister(){
        Fragment fragment = null;
        try {
            fragment = (Fragment) new RegisterFragment();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentFrame, fragment)
                .commit();
    }


    public void GotToLogin(){
        Fragment fragment = null;
        try {
            fragment = (Fragment) new LoginFragment();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentFrame, fragment)
                .commit();
    }


    //region Login fragment
    @Override
    public void OnSuccessfulLogin(User user) {
        Preference.saveString(this, Memory.USER_ID, user._id);
        if(user.getVerified()==true){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }else{
            Fragment fragment = null;
            try {
                fragment = ActivationFragment.newInstance(user.code, user._id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragmentFrame, fragment).commit();
        }
    }
    @Override
    public void OnSignupPressed(){

    }
    //endregion
    @Override
    public void OnSuccessfulRegister(User user) {
        Preference.saveString(this, Memory.USER_ID, user._id);
        Fragment fragment = null;
        try {
            fragment = ActivationFragment.newInstance(user.code, user._id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentFrame, fragment).commit();

    }

}
