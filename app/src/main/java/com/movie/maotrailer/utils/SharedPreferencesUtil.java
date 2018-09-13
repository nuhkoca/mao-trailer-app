package com.movie.maotrailer.utils;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class SharedPreferencesUtil {

    private SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferencesUtil(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void putIntData(String key, int val) {
        sharedPreferences.edit().putInt(key, val).apply();
    }

    public int getIntData(String key, int defVal) {
        return sharedPreferences.getInt(key, defVal);
    }

    public void putStringData(String key, String val) {
        sharedPreferences.edit().putString(key, val).apply();
    }

    public String getStringData(String key, String defVal) {
        return sharedPreferences.getString(key, defVal);
    }

    public void putBooleanData(String key, boolean val) {
        sharedPreferences.edit().putBoolean(key, val).apply();
    }

    public boolean getBooleanData(String key, boolean defVal) {
        return sharedPreferences.getBoolean(key, defVal);
    }
}
