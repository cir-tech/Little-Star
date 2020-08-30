package com.cirtech.littlestar.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.cirtech.littlestar.R;

public class TheoricalAnimalsColorsActivity extends Activity implements View.OnClickListener{

    private ImageView urso;
    private ImageView zebra;
    private ImageView girafa;
    private ImageView elefante;
    private ImageView hipopotamo;
    private ImageView leao;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teorical_animals);

        urso = (ImageView) findViewById(R.id.idurso);
        zebra= (ImageView) findViewById(R.id.idzebra);
        girafa = (ImageView) findViewById(R.id.idgirafa);
        elefante = (ImageView) findViewById(R.id.idelefante);
        hipopotamo = (ImageView) findViewById(R.id.idhipopotamo);
        leao = (ImageView) findViewById(R.id.idleao);


        urso.setOnClickListener(this);
        zebra.setOnClickListener(this);
        girafa.setOnClickListener(this);
        elefante.setOnClickListener(this);
        hipopotamo.setOnClickListener(this);
        leao.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.idurso:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.urso);
                tocarSom();
                break;
            case R.id.idzebra:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.zebra);
                tocarSom();
                break;
            case R.id.idgirafa:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.girafa);
                tocarSom();
                break;
            case R.id.idelefante:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.elefante);
                tocarSom();
                break;
            case R.id.idhipopotamo:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.hipopotamo);
                tocarSom();
                break;
            case R.id.idleao:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.leao);
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
