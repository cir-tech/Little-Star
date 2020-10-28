package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cirtech.littlestar.R;

import java.util.ArrayList;

public class PracticeColorsActivity extends AppCompatActivity {

    private static final String PREFERENCE = "preferencesAppInfo";


    private int currentColor = 0;
    private String[] colors = {"brown", "black", "white","yellow","blue","gray","orange"};
    private Integer[] imgResource = {R.drawable.marrom,R.drawable.preto,R.drawable.branco,R.drawable.amarelo,R.drawable.azul,R.drawable.cinza,R.drawable.laranja};
    private Integer[] phraseResource = {R.drawable.lama,R.drawable.frase_cor,R.drawable.nuvem,R.drawable.frase_cor,R.drawable.frase_cor,R.drawable.frase_cor,R.drawable.frase_cor};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_colors);

        //recuperando dados enviados pela intent
        String current = this.getColor();
        this.updateView();

        Toast.makeText(this, current, Toast.LENGTH_SHORT).show();
        ImageView btnVoice = findViewById(R.id.idbtnVoiceColor);

        btnVoice.setOnClickListener(this::getSpeechInput);

    }


    public void getSpeechInput(View view) {

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

                if( result.get(0).toLowerCase().equals(this.colors[this.currentColor])){
                    Toast.makeText(this, "Parabéns, você acertouu!!", Toast.LENGTH_SHORT).show();

                    this.currentColor++;
                    if(this.currentColor <= this.colors.length){
                        Intent refresh = getIntent();
                        finish();

                        refresh.putExtra("currentColor", this.currentColor);
                        startActivity(refresh);
                    }

                    else {
                        Toast.makeText(this, "Parabéeens!, você terminou a sessão", Toast.LENGTH_LONG).show();
                        Intent changePage = new Intent(getApplicationContext(), Congratulations.class);

                        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,0); //0 é preferencia privada
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("section-colors","ok");
                        editor.apply();   //apply()
                        startActivity(changePage);
                    }


                }else Toast.makeText(this, "Errou feio, errou rude!", Toast.LENGTH_LONG).show();


            }

        } else {
            throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }


    private String getColor(){
        Intent intent = getIntent();
        if(intent.hasExtra("currentColor")) {
            if(intent.getExtras() != null)  this.currentColor =  intent.getExtras().getInt("currentColor");
        }
        return this.colors[this.currentColor];
    }

    private void updateView(){
        ImageView frase = findViewById(R.id.idfraseCor);
        ImageView color = findViewById(R.id.idcolor);
        frase.setBackgroundResource(this.phraseResource[this.currentColor]);
        color.setBackgroundResource(this.imgResource[this.currentColor]);
    }

}
