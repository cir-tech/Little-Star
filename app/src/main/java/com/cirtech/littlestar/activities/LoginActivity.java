package com.cirtech.littlestar.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cirtech.littlestar.R;
import com.cirtech.littlestar.services.AuthenticateUser;
import com.cirtech.littlestar.util.GsonUtil;

import java.util.Map;


//import com.cirtech.littlestar.splashScreen.MainScreen;

public class LoginActivity extends AppCompatActivity implements AuthenticateUser.GetJSONListener{

    private static final String PREFERENCE = "preferencesAppInfo";

    private ImageView logo;
    private ImageView btnLogar;
    private EditText login;
    private EditText password;
    private TextView cadastro;

    private ProgressBar loadSpinner;

    @Override
    public void onRemoteCallComplete(String response,String status){
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,0); //0 é preferencia privada
        // a qual apenas nosso app pode ver
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(!status.equals("ok")){
            Log.i("resultado do servidor",response);
            loadSpinner.setVisibility(View.GONE);
            this.ImageViewEnable(btnLogar,true);
            Toast.makeText(LoginActivity.this,"O login falhou, tente novamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Map dataResponse = GsonUtil.json_decode(response);

            Log.i("resultado do servidor",dataResponse.get("status").toString());
            loadSpinner.setVisibility(View.GONE);
            this.ImageViewEnable(btnLogar,true);

            if(dataResponse.get("status").toString().equals("success")){
                Toast.makeText(LoginActivity.this,"Logado com sucesso!", Toast.LENGTH_SHORT).show();
                editor.putString("logado","logado");
                 editor.apply();   //commit()
                redirecionar();
            }else Toast.makeText(LoginActivity.this,"O login falhou, tente novamente", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logo = findViewById(R.id.idLogoLogin);
        btnLogar = findViewById(R.id.idbtnLogar);
        login = findViewById(R.id.idlogin);
        password = findViewById(R.id.idpassword);
        cadastro = findViewById(R.id.idgotocadastro);
        loadSpinner = findViewById(R.id.idloadlogin);


        btnLogar.setOnClickListener(view -> logarApp());
        cadastro.setOnClickListener(view -> goToCadastro());

        redirecionaIfLogou();
    }

    private void logarApp(){

        String loginString = this.login.getText().toString();
        String passwordString = this.password.getText().toString();


        if(loginString.equals("") || passwordString.equals("")) {
            Toast.makeText(LoginActivity.this, "Por favor, preencher corretamente", Toast.LENGTH_SHORT).show();
        }
        else {
            this.loadSpinner.setVisibility(View.VISIBLE);
            this.ImageViewEnable(btnLogar,false);
            new AuthenticateUser(loginString,passwordString).execute(this);
        }

//        if(loginString.equals("") || passwordString.equals("")){
//            Toast.makeText(LoginActivity.this,"Por favor, preencher corretamente", Toast.LENGTH_SHORT).show();
//        }else if(loginString.equals("desenv") && passwordString.equals("12345") ){
//            Toast.makeText(LoginActivity.this,"Logado com sucesso!", Toast.LENGTH_SHORT).show();
//            editor.putString("logado","logado");
////            SharedPreferences.Editor remove (String key)
////            SharedPreferences.Editor.clear()
//            editor.apply();   //commit()
//            redirecionar();
//        }else {
//            Toast.makeText(LoginActivity.this,"Login ou senha incorreto!", Toast.LENGTH_SHORT).show();
//        }

    }

    private void goToCadastro(){
        Intent changePage = new Intent(LoginActivity.this, CadastroActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                LoginActivity.this, logo, ViewCompat.getTransitionName(logo));
        startActivity(changePage, options.toBundle());
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
//        else{
//            Toast.makeText(LoginActivity.this,"ja nao foi logado", Toast.LENGTH_SHORT).show();
//        }
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

    private void ImageViewEnable(ImageView imageView, Boolean choice){
                imageView.setEnabled(choice);
                if(choice){
                    imageView.setImageAlpha(255);
                }
                else imageView.setImageAlpha(100);

    }
}
