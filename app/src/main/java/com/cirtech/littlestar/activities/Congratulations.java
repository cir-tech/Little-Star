package com.cirtech.littlestar.activities;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.ContentResolver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import com.cirtech.littlestar.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Congratulations extends AppCompatActivity {
    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    //    android.hardware.Camera camera;
//    FrameLayout frameLayout;
//    ShowCamera showCamera;
    ImageView selectedImage;
    Button cameraBtn;
    ImageView btnRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        btnRetornar = findViewById(R.id.btnRetornar);

        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePage = new Intent(Congratulations.this, ListaAtividadesActivity.class);
                startActivity(changePage);
            }
        });




        selectedImage = findViewById(R.id.displayImageView);
        cameraBtn = findViewById(R.id.cameraBtn);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCameraPermissions();
            }
        });


        //SCREENSHOT
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        }

    private void askCameraPermissions() {

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);

        }else {
            openCamera();
        }


    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == CAMERA_PERM_CODE){
            if (grantResults.length > 1 && grantResults[1] == PackageManager.PERMISSION_GRANTED ){
                // abre a camera
            }else{
                Toast.makeText(this, "Voce precisa permitir o uso da camera para continuar!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST_CODE);

    }
    @Override
    protected void  onActivityResult (int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            selectedImage.setImageBitmap(image);

        }
    }


    public void ScreenshotButton(View view){
        View view1 = getWindow().getDecorView().getRootView();
        view1.setDrawingCacheEnabled(true);
        Bitmap bitmap =  Bitmap.createBitmap(view1.getDrawingCache());
        view1.setDrawingCacheEnabled(false);


        String filePath = Environment.getExternalStorageDirectory()+ "/Download/"+ Calendar.getInstance().getTime().toString()+".jpeg";
        File fileScreenshot = new File(filePath);

        FileOutputStream fileOutputStream = null;

            try {
                fileOutputStream = new FileOutputStream(fileScreenshot);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(fileScreenshot);
            intent.setDataAndType(uri,"image/png");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);

        }





        }




