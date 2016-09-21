package com.diss.chocolife_test.mvc.controllers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.diss.chocolife_test.R;

/**
 * Created by dmitry on 19.09.16.
 */

public class ActSplashScreen extends AppCompatActivity {

    Handler handler = new Handler();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash_screen);
        handler.postDelayed(() -> {
            this.startActivity(new Intent(this,ActMainScreen.class));
        },2000);
    }
}
