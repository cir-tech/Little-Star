package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.cirtech.littlestar.R;
import com.cirtech.littlestar.adapters.CustomAdapterGridAtividades;
import com.cirtech.littlestar.adapters.CustomAdapterTest;

public class GridExerciciosAtividades extends AppCompatActivity {

    GridView lst;
    String[] fruitname = {"Animals", "Colors", "Animals and Colors"};
    int[] images = {R.drawable.animals, R.drawable.colors, R.drawable.gato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_exercicios_atividades);

        lst = findViewById(R.id.idGridAtividade);
        CustomAdapterGridAtividades adapter = new CustomAdapterGridAtividades(this, fruitname, images);
        lst.setAdapter(adapter);
    }
}
