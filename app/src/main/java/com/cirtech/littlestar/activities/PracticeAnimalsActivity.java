package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cirtech.littlestar.R;

import java.util.ArrayList;
import java.util.Locale;

public class PracticeAnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_animals);


        ImageView btnVoice = findViewById(R.id.idbtnVoice);

        btnVoice.setOnClickListener(this::getSpeechInput);

    }

    public void getSpeechInput(View view) {

        String texto ="ola";
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Seu Dispositivo Não Suporta Este Serviço! ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                Log.d("myTag","foi");
                Log.i("t","teste");

                if( result.get(0).equals("dog")){
                    Toast.makeText(this, "Parabéns, você acertouu!!", Toast.LENGTH_SHORT).show();
                }
            }

        } else {
            throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }
}



