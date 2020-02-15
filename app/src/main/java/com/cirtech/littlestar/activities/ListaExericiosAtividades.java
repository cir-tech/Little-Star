package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.cirtech.littlestar.R;
import com.cirtech.littlestar.adapters.CustomAdapterTest;


public class ListaExericiosAtividades extends AppCompatActivity {

    String tipoAtividade;
    ListView lst;
    String[] fruitname = {"Animals", "Colors", "Animals and Colors"};
    int[] images = {R.drawable.animals, R.drawable.colors, R.drawable.gato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_exericios_teorica);

        Bundle extra = getIntent().getExtras();
        if(extra != null ){
            tipoAtividade = extra.getString("tipoAtividade");
        }

        lst = findViewById(R.id.listViewPraticaId);
        TextView tituloTipo = findViewById(R.id.idTituloTipoAtividade);
        if(tipoAtividade.equals("atividadePratica")) tituloTipo.setText("Vamos praticar!");
        else tituloTipo.setText("Vamos aprender!");

        CustomAdapterTest adapter = new CustomAdapterTest(this, fruitname, images);
        lst.setAdapter(adapter);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruitname);
//        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // String value =(String)lv.getItemAtPosition(position);
                Intent intent;
                if (position == 0) {
                    if(tipoAtividade.equals("atividadeTeorica")){
                        intent = new Intent(ListaExericiosAtividades.this, TeoricaActivity.class);
//                        intent.putExtra("tipoAtividade","atividadeTeorica");
                    }
                    else {
                        intent = new Intent(ListaExericiosAtividades.this, PraticaActivity.class);
//                        intent.putExtra("tipoAtividade","atividadePratica");
                    }
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




