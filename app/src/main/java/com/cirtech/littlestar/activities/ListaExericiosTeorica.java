package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // String value =(String)lv.getItemAtPosition(position);

                if (position == 0) {
                    Intent intent = new Intent(ListaExericiosTeorica.this, TeoricaActivity.class);
                    startActivity(intent);
                } //else if (position == 1) {
//                    Intent intent = new Intent(this, List2.class);
//                    startActivity(intent);
//                } else if (position == 2) {
//                    Intent intent = new Intent(this, List3.class);
//                    startActivity(intent);
//                }

            }
        });
    }
}




