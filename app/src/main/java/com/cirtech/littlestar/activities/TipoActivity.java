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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);

        ImageView btnTeorica = findViewById(R.id.idbtnteorica);

        btnTeorica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(TipoActivity.this, TeoricaActivity.class);
                changePage.putExtra("Animals", "TeoricaAnimals");
                changePage.getExtras();
                startActivity(changePage);
            }
        });
    }
}
