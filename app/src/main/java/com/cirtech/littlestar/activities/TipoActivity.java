package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cirtech.littlestar.R;

public class TipoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //recebe dados de outra tela
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("Atividades");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);

        ImageView btnTeorica = findViewById(R.id.idbtnteorica);
        btnTeorica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.equals("Animals")) {
                    Intent changePage = new Intent(TipoActivity.this, TheoricalAnimalActivity.class);
                    startActivity(changePage);
                }
                if (nome.equals("Colors")) {
                    Intent changePage = new Intent(TipoActivity.this, TheoricalColorsActivity.class);
                    startActivity(changePage);
                }
                if (nome.equals("AnimalsColors")) {
                    Intent changePage = new Intent(TipoActivity.this, TheoricalAnimalsColors.class);
                    startActivity(changePage);
            }}
        });
        ImageView btnPratica = findViewById(R.id.idbtnpratica);
        btnPratica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.equals("Animals")) {
                    Intent changePage = new Intent(TipoActivity.this, PracticeAnimalsActivity.class);
                    startActivity(changePage);

                }
                if (nome.equals("Colors")) {
                    Intent changePage = new Intent(TipoActivity.this, PracticeColorsActivity.class);
                    startActivity(changePage);
                }
            }
        });




    }}