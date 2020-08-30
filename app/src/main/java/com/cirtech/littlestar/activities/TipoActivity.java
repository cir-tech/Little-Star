package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cirtech.littlestar.R;

public class TipoActivity extends AppCompatActivity {

    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //recebe dados de outra tela
        Bundle dados = getIntent().getExtras();
        nome = dados.getString("Atividade");

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
            }
        });
        ImageView btnPratica = findViewById(R.id.idbtnpratica);
        btnPratica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.equals("Animals")) {
                    Intent changePage = new Intent(TipoActivity.this, PracticeAnimalsActivity.class);
                    startActivity(changePage);
                }
                //Cores
                if (nome.equals("Colors")) {
                    Intent changePage = new Intent(TipoActivity.this, TheoricalColorsActivity.class);
                    startActivity(changePage);
                }

            }
        });



    }}