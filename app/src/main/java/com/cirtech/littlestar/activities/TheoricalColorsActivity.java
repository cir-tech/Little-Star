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


                marrom.setOnClickListener(this);
                preto.setOnClickListener(this);
                branco.setOnClickListener(this);
                amarelo.setOnClickListener(this);
                azul.setOnClickListener(this);
                cinza.setOnClickListener(this);




            }

            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.idMarrom:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.leao);
                        tocarSom();
                        break;
                    case R.id.idPreto:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.zebra);
                        tocarSom();
                        break;
                    case R.id.idBranco:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.elefante);
                        tocarSom();
                        break;
                    case R.id.idAmarelo:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.hipopotamo);
                        tocarSom();
                        break;
                    case R.id.idAzul:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.girafa);
                        tocarSom();
                        break;
                    case R.id.idCinza:
                        mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TheoricalColorsActivity.this,R.raw.urso);
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







