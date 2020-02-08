package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cirtech.littlestar.R;
import com.cirtech.littlestar.adapters.CustomAdapterTest;


public class ListaExericiosTeorica extends AppCompatActivity {

    ListView lst;
    String[] fruitname = {"Animals", "Colors", "Animals and Colors"};
    int[] images = {R.drawable.animals, R.drawable.colors, R.drawable.gato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_exericios_teorica);
        lst = findViewById(R.id.listViewPraticaId);

        CustomAdapterTest adapter = new CustomAdapterTest(this, fruitname, images);
        lst.setAdapter(adapter);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruitname);
//        lst.setAdapter(adapter);

    }
}




