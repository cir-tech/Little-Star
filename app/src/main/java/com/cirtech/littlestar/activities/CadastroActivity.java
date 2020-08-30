package com.cirtech.littlestar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cirtech.littlestar.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ImageView btnCadastro = findViewById(R.id.idbtnCadastro);
        btnCadastro.setOnClickListener(view -> {
            Toast.makeText(CadastroActivity.this, "Cadastro Efetuado com Sucesso", Toast.LENGTH_SHORT).show();
            Intent changePage = new Intent(CadastroActivity.this, LoginActivity.class);
            startActivity(changePage);
        });
    }
}



