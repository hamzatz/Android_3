package com.example.android3.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Handler;

import com.example.android3.App;
import com.example.android3.R;
import com.example.android3.ui.main.MainActivity;
import com.example.android3.ui.onboard.OnBoardActivity;


public class SplashActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //activitySelectorWithTimer();
       selectActivity();

    }



    private void selectActivity() {

            if (App.getPreference().getFirstLaunch()){
                App.getPreference().setFirstLaunch();
                OnBoardActivity.start(this);
            }else {

                MainActivity.start(this);
            }
         finish();

        }


    private void activitySelectorWithTimer(){

        int DELAY=2000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //selectActivity();

            }
        },DELAY);

    }
}