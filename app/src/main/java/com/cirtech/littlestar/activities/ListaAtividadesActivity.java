package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cirtech.littlestar.R;

public class ListaAtividadesActivity extends AppCompatActivity {

    private static final String PREFERENCE = "preferencesAppInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_atividades);

        ImageView btnAnimals = findViewById(R.id.idbtnAnimals);
        ImageView btnColors = findViewById(R.id.idbtnColors);
        ImageView btnAnimalsColors = findViewById(R.id.idbtnAnimalsColors);


        btnColors.setEnabled(false);
        btnColors.setImageAlpha(100);
        btnAnimalsColors.setEnabled(false);
        btnAnimalsColors.setImageAlpha(100);

        this.setEnable(btnColors,"section-animals");
        this.setEnable(btnColors,"section-colors");



        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(ListaAtividadesActivity.this, TipoActivity.class);
                changePage.putExtra("Atividade", "Animals");
                startActivity(changePage);
            }
        });

        btnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(ListaAtividadesActivity.this, TipoActivity.class);
                changePage.putExtra("Atividade", "Colors");
                startActivity(changePage);
            }
        });

        btnAnimalsColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(ListaAtividadesActivity.this, TipoActivity.class);
                changePage.putExtra("Atividade", "AnimalsColors");
                startActivity(changePage);
            }
        });
    }


    private void setEnable(ImageView imageView, String keyword){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,0);

        if(sharedPreferences.contains(keyword)) {
            String sectionAnimals = sharedPreferences.getString(keyword, "null");  //o segundo parametro é um default value
            if(sectionAnimals.equals("ok")) {
                imageView.setEnabled(true);
                imageView.setImageAlpha(255);
            }
            Log.i("doiiiiiiiiiihajs","nao");
        }

    }
}



