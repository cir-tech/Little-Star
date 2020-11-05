package com.cirtech.littlestar.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.cirtech.littlestar.R;
import com.cirtech.littlestar.services.RegisterUser;
import com.cirtech.littlestar.util.GsonUtil;

import java.util.Map;

public class CadastroActivity extends AppCompatActivity implements RegisterUser.GetJSONListener {

    private ImageView btnCadastro;

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText passwordConfirmation;

    private ProgressBar loadSpinner;

    @Override
    public void onRemoteCallComplete(String response,String status){
//        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,0); //0 é preferencia privada
        // a qual apenas nosso app pode ver
//        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(!status.equals("ok")){
            Log.i("resultado do servidor",response);
            loadSpinner.setVisibility(View.GONE);
            this.ImageViewEnable(btnCadastro,true);
            Toast.makeText(CadastroActivity.this,"O cadastro falhou, tente novamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Map dataResponse = GsonUtil.json_decode(response);

            Log.i("resultado do servidor",dataResponse.get("status").toString());
            loadSpinner.setVisibility(View.GONE);
            this.ImageViewEnable(btnCadastro,true);

            if(dataResponse.get("status").toString().equals("success")){
                Toast.makeText(CadastroActivity.this,"Logado com sucesso!", Toast.LENGTH_SHORT).show();
//                editor.putString("logado","logado");
//                editor.apply();   //commit()
                redirecionar();
            }else Toast.makeText(CadastroActivity.this,"O login falhou, tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastro = findViewById(R.id.idbtnCadastro);

        name = findViewById(R.id.idname);
        email = findViewById(R.id.idemail);
        password = findViewById(R.id.idpassword);
        passwordConfirmation = findViewById(R.id.idpasswordconfirmation);

        loadSpinner = findViewById(R.id.idloadcadastro);

        btnCadastro.setOnClickListener(view -> register());
    }

    private void redirecionar(){
        Toast.makeText(CadastroActivity.this, "Cadastro Efetuado com Sucesso", Toast.LENGTH_SHORT).show();
        Intent changePage = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(changePage);
        finish();
    }

    private void register(){

        String nameString = this.name.getText().toString();
        String emailString = this.email.getText().toString();
        String passwordString = this.password.getText().toString();
        String passwordConfirmationString = this.passwordConfirmation.getText().toString();

        if(nameString.equals("") || emailString.equals("") || passwordString.equals("") || passwordConfirmationString.equals("")){
            Toast.makeText(CadastroActivity.this, "Por favor, preencher corretamente", Toast.LENGTH_SHORT).show();
        }
        else {
            this.loadSpinner.setVisibility(View.VISIBLE);
            this.ImageViewEnable(btnCadastro,false);
            new RegisterUser(nameString,emailString,passwordString,passwordConfirmationString).execute(this);
        }
    }

    private void ImageViewEnable(ImageView imageView, Boolean choice){
        imageView.setEnabled(choice);
        if(choice){
            imageView.setImageAlpha(255);
        }
        else imageView.setImageAlpha(100);

    }
}



