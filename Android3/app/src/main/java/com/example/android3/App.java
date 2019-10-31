package com.example.android3;

import android.app.Application;

import com.example.android3.data.SharedPreferenceHelper;

public class App extends Application {

    private static SharedPreferenceHelper preferenceHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        preferenceHelper=new SharedPreferenceHelper(this);
    }
    public static SharedPreferenceHelper getPreference(){
        return preferenceHelper;
    }
}
