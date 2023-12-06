package com.devandroidmarcoantonio.lista.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.devandroidmarcoantonio.lista.DataBase.DBHelper;
import com.devandroidmarcoantonio.lista.R;


public class activity_splash extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        cumutartelaSplash();
    }

    private void cumutartelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                DBHelper db = new DBHelper(activity_splash.this);

                Intent telaPrincipal = new Intent(activity_splash.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        },TIME_OUT_SPLASH);
    }
}