package com.tiringbring.expensesonline.SharedData;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preference {
    static private SharedPreferences Manager(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    static public void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = Manager(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    static public boolean loadBoolean(Context context, String key, boolean defaultValue) {
        return Manager(context).getBoolean(key, defaultValue);
    }


    static public void saveString(Context context, String key, String value) {
        SharedPreferences.Editor editor = Manager(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    static public String loadString(Context context, String key, String defaultValue) {
        return Manager(context).getString(key, defaultValue);
    }

    static public void saveInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = Manager(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    static public int loadInt(Context context, String key, int defaultValue) {
        return Manager(context).getInt(key, defaultValue);
    }

    static public void saveFloat(Context context, String key, float value) {
        SharedPreferences.Editor editor = Manager(context).edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    static public float loadFloat(Context context, String key, float defaultValue) {
        return Manager(context).getFloat(key, defaultValue);
    }



}
