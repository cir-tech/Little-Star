package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cirtech.littlestar.R;

public class ListaAtividadesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_atividades);

        ImageView btnAnimals = findViewById(R.id.idbtnAnimals);
        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(ListaAtividadesActivity.this, TipoActivity.class);
                changePage.putExtra("Atividade", "Animals");
                startActivity(changePage);
            }
        });
        ImageView btnColors = findViewById(R.id.idbtnColors);
        btnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(ListaAtividadesActivity.this, TipoActivity.class);
                changePage.putExtra("Atividade", "Colors");
                startActivity(changePage);
            }
        });
        ImageView btnAnimalsColors = findViewById(R.id.idbtnAnimalsColors);
        btnAnimalsColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(ListaAtividadesActivity.this, TipoActivity.class);
                changePage.putExtra("Atividade", "AnimalsColors");
                startActivity(changePage);
            }
        });
    }

}



