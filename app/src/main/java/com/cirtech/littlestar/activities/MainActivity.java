package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cirtech.littlestar.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);

//        Button botaoPratica =  findViewById(R.id.idPratica);
//        Button botaoTeorica =  findViewById(R.id.idTeorico);
//
//        botaoPratica.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent changePage = new Intent(MainActivity.this, ListaExericiosAtividades.class);
//                changePage.putExtra("tipoAtividade","atividadePratica");
//                startActivity(changePage);
//            }
//        });
//
//        botaoTeorica.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent changePage = new Intent(MainActivity.this, ListaExericiosAtividades.class);
//                changePage.putExtra("tipoAtividade","atividadeTeorica");
//                startActivity(changePage);
//            }
//        });
    }
}
