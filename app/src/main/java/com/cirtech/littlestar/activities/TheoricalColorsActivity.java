package com.cirtech.littlestar.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cirtech.littlestar.R;



public class TheoricalColorsActivity extends AppCompatActivity implements View.OnClickListener{

            private ImageView marrom;
            private ImageView preto;
            private ImageView branco;
            private ImageView amarelo;
            private ImageView azul;
            private ImageView cinza;
            private ImageView laranja;
            private MediaPlayer mediaPlayer;
            @Override
            protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_teorical_cores);

                marrom = (ImageView) findViewById(R.id.idMarrom);
                preto = (ImageView) findViewById(R.id.idPreto);
                branco = (ImageView) findViewById(R.id.idBranco);
                amarelo = (ImageView) findViewById(R.id.idAmarelo);
                azul = (ImageView) findViewById(R.id.idAzul);
                cinza = (ImageView) findViewById(R.id.idCinza);
                laranja = (ImageView) findViewById(R.id.idLaranja);


                marrom.setOnClickListener(this);
                preto.setOnClickListener(this);
                branco.setOnClickListener(this);
                amarelo.setOnClickListener(this);
                azul.setOnClickListener(this);
                cinza.setOnClickListener(this);
                laranja.setOnClickListener(this);




            }

            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.idMarrom:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.marrom);
                        tocarSom();
                        break;
                    case R.id.idPreto:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.preto);
                        tocarSom();
                        break;
                    case R.id.idBranco:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.branco);
                        tocarSom();
                        break;
                    case R.id.idAmarelo:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.amarelo);
                        tocarSom();
                        break;
                    case R.id.idAzul:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.azul);
                        tocarSom();
                        break;
                    case R.id.idCinza:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.cinza);
                        tocarSom();
                        break;
                    case R.id.idLaranja:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.laranja);
                        tocarSom();
                        break;

                }
            }
            public void tocarSom(){
                if(mediaPlayer != null){
                    mediaPlayer.start();
                }
            }

        }







