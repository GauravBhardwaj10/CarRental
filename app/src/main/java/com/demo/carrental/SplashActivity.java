package com.demo.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH= 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent newIntent=new Intent(SplashActivity.this,WelcomeActivity.class);
                startActivity(newIntent);
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}