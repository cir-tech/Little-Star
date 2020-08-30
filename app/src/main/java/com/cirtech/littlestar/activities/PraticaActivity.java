//package com.cirtech.littlestar.activities;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.speech.RecognizerIntent;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//



//import androidx.appcompat.app.AppCompatActivity;
//
//import com.cirtech.littlestar.R;
//
//import java.util.ArrayList;
//import java.util.Locale;
//
//public class PraticaActivity extends AppCompatActivity {
//
//    private TextView txvResult;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pratica);
//        txvResult = findViewById(R.id.idTxtResult);
//
//        ImageView urso = findViewById(R.id.idCaoPratica);
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mixed_anim);
//        urso.startAnimation(animation);
//
//    }
//
//    public void getSpeechInput(View view) {
//
////        String texto ="ola";
////        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(intent, 10);
//        } else {
//            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 10) {
//            if (resultCode == RESULT_OK && data != null) {
//                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
////                txvResult.setText(result.get(0));
////                Log.d('minhaTag',"foi");
////                Log.i("t","teste");
//                Intent intent = new intent();
//
//                if()put.extra("")
//                if( result.get(0).equals("dog")){
//                    txvResult.setText("Parabéns, você acertou!");
//                } else  txvResult.setText("Você está no caminho certo, tente novamente!");
//            }
//        } else {
//            throw new IllegalStateException("Unexpected value: " + requestCode);
//        }
//    }
//}
