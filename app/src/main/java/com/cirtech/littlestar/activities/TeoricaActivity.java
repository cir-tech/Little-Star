//package com.cirtech.littlestar.activities;
//
//import android.app.Activity;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//
//import com.cirtech.littlestar.R;
//
//public class TeoricaActivity extends Activity implements View.OnClickListener{
//
//    private ImageView cao;
//    private ImageView gato;
//    private ImageView leao;
//    private ImageView macaco;
//    private ImageView ovelha;
//    private ImageView vaca;
//    private MediaPlayer mediaPlayer;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_teorical_animals);
//
//        cao = (ImageView) findViewById(R.id.caoid);
//        gato = (ImageView) findViewById(R.id.gatoid);
//        leao = (ImageView) findViewById(R.id.leaoid);
//        macaco = (ImageView) findViewById(R.id.macacoid);
//        ovelha = (ImageView) findViewById(R.id.ovelhaid);
//        vaca = (ImageView) findViewById(R.id.vacaid);
//
//
//        cao.setOnClickListener(this);
//        gato.setOnClickListener(this);
//        leao.setOnClickListener(this);
//        macaco.setOnClickListener(this);
//        ovelha.setOnClickListener(this);
//        vaca.setOnClickListener(this);
//
//
//
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()){
//            case R.id.caoid:
//                mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TeoricaActivity.this,R.raw.cao);
//                tocarSom();
//                break;
//            case R.id.gatoid:
//                mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TeoricaActivity.this,R.raw.gato);
//                tocarSom();
//                break;
//            case R.id.leaoid:
//                mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TeoricaActivity.this,R.raw.leao);
//                tocarSom();
//                break;
//            case R.id.macacoid:
//                mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TeoricaActivity.this,R.raw.macaco);
//                tocarSom();
//                break;
//            case R.id.ovelhaid:
//                mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TeoricaActivity.this,R.raw.ovelha);
//                tocarSom();
//                break;
//            case R.id.vacaid:
//                mediaPlayer = MediaPlayer.create(com.cirtech.littlestar.activities.TeoricaActivity.this,R.raw.vaca);
//                tocarSom();
//
//                break;
//        }
//    }
//    public void tocarSom(){
//        if(mediaPlayer != null){
//            mediaPlayer.start();
//        }
//    }
//}