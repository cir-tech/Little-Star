package com.cirtech.littlestar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.widget.EditText;
import android.widget.Toast;

import com.cirtech.littlestar.R;
import com.cirtech.littlestar.services.AuthenticateUser;


//import com.cirtech.littlestar.splashScreen.MainScreen;

public class LoginActivity extends AppCompatActivity {

    private static final String PREFERENCE = "preferencesAppInfo";

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView btnLogar = findViewById(R.id.idbtnLogar);
        logo = findViewById(R.id.idLogoLogin);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logarApp();
            }
        });

        redirecionaIfLogou();
    }


//
    private void logarApp(){
        EditText login = findViewById(R.id.idlogin);
        EditText password = findViewById(R.id.idpassword);

        new AuthenticateUser().execute();

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,0); //0 é preferencia privada
        // a qual apenas nosso app pode ver
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String loginString = login.getText().toString();
        String passwordString = password.getText().toString();

        if(loginString.equals("") || passwordString.equals("")){
            Toast.makeText(LoginActivity.this,"Por favor, preencher corretamente", Toast.LENGTH_SHORT).show();
        }else if(loginString.equals("desenv") && passwordString.equals("12345") ){
            Toast.makeText(LoginActivity.this,"Logado com sucesso!", Toast.LENGTH_SHORT).show();
            editor.putString("logado","logado");
//            SharedPreferences.Editor remove (String key)
//            SharedPreferences.Editor.clear()
            editor.apply();   //commit()
            redirecionar();
        }else {
            Toast.makeText(LoginActivity.this,"Login ou senha incorreto!", Toast.LENGTH_SHORT).show();
        }

    }


    private void redirecionar(){
        Intent changePage = new Intent(LoginActivity.this, MainActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                LoginActivity.this, logo, ViewCompat.getTransitionName(logo));
        startActivity(changePage, options.toBundle());
        finish();
    }

    private void redirecionaIfLogou(){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,0);
        if(sharedPreferences.contains("logado")){
            String logado = sharedPreferences.getString("logado","nao logado");  //o segundo parametro é um default value
            if(logado.equals("logado")){
                Toast.makeText(LoginActivity.this,"ja foi logado", Toast.LENGTH_SHORT).show();
                redirecionar();
            }
        }
        else{
            Toast.makeText(LoginActivity.this,"ja nao foi logado", Toast.LENGTH_SHORT).show();
        }
    }

    public void openBrowser(View view){

        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data Uri
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }
}
