package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
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

    private int currentAnimal = 0;
    private String[] animals = {"bear", "zebra", "giraffe","elephant","hippopotamus","lion"};
    private Integer[] imgResource = {R.drawable.urso,R.drawable.zebra,R.drawable.girafa,R.drawable.elefante,R.drawable.hipopotamo,R.drawable.leao};
    private Integer[] phraseResource = {R.drawable.mel,R.drawable.frase_zebra,R.drawable.frase_girafa,R.drawable.frase_elefante,R.drawable.frase_hipo,R.drawable.frase_leao};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_animals);

        //recuperando dados enviados pela intent
        String current = this.getAnimal();
        this.updateView();

        Toast.makeText(this, current, Toast.LENGTH_SHORT).show();
        ImageView btnVoice = findViewById(R.id.idbtnVoice);

        btnVoice.setOnClickListener(this::getSpeechInput);

    }

    public void getSpeechInput(View view) {

//        String texto ="ola";
//        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");

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

                if( result.get(0).toLowerCase().equals(this.animals[this.currentAnimal])){
                    Toast.makeText(this, "Parabéns, você acertouu!!", Toast.LENGTH_SHORT).show();

                    this.currentAnimal++;
                    if(this.currentAnimal <= this.animals.length){
                        Intent refresh = getIntent();
                        finish();

                        refresh.putExtra("currentAnimal", this.currentAnimal);
                        startActivity(refresh);
                    }

                    else Toast.makeText(this, "Parabéeens!, você terminou a sessão", Toast.LENGTH_LONG).show();


                }else Toast.makeText(this, "Errou feio, errou rude!", Toast.LENGTH_LONG).show();


            }

        } else {
            throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }


    private String getAnimal(){
        Intent intent = getIntent();
        if(intent.hasExtra("currentAnimal")) {
            if(intent.getExtras() != null)  this.currentAnimal =  intent.getExtras().getInt("currentAnimal");
        }
        return this.animals[this.currentAnimal];
    }

    private void updateView(){
        ImageView frase = findViewById(R.id.idfraseanimal);
        ImageView animal = findViewById(R.id.idanimal);
        frase.setBackgroundResource(this.phraseResource[this.currentAnimal]);
        animal.setBackgroundResource(this.imgResource[this.currentAnimal]);
    }

}



