package com.cirtech.littlestar.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cirtech.littlestar.R;
import com.cirtech.littlestar.activities.LoginActivity;


public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_main_screen);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView splash = findViewById(R.id.idmainsplash);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        splash.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 1800);
    }

    private void mostrarMainActivity() {
        Intent intent = new Intent(
                MainScreen.this, LoginActivity.class
        );
        startActivity(intent);
        finish();
    }
}
