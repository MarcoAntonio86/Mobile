package devandroid.marcoantonio.appgaseta.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.marcoantonio.appgaseta.R;

public class SplashActivity extends AppCompatActivity {

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
                Intent telaPrincipal = new Intent(SplashActivity.this, GasEtaAcivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        },TIME_OUT_SPLASH);
    }
}