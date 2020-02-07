package com.cirtech.littlestar.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cirtech.littlestar.R;
import com.cirtech.littlestar.activities.MainActivity;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_main_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 1500);
    }

    private void mostrarMainActivity() {
        Intent intent = new Intent(
                MainScreen.this, MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}
