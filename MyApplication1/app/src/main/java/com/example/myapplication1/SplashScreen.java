package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private int waktu_loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //pindah setelah 4 detik
                Intent home = new Intent(SplashScreen.this, OnboardingScreen.class);
                startActivity(home);
                finish();

            }
        }, waktu_loading);
    }
}
