package com.igor.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ControlaFlashCamera {

    CameraManager myCamera;
    private String idCamera;

    @TargetApi(21)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCamera = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try {
            idCamera = myCamera.getCameraIdList()[0];
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void acendeApaga(boolean estadoFlah) {

        try {

            if(estadoFlah){
                //Toast.makeText(this, "Flash Ativado", Toast.LENGTH_SHORT).show();

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    myCamera.setTorchMode(idCamera, true);
                }
            }else{
                //Toast.makeText(this, "Flash Apagado", Toast.LENGTH_SHORT).show();

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    myCamera.setTorchMode(idCamera, true);
                }

            }

        }catch (Exception e){
                e.printStackTrace();
        }


    }

    public void somar(View view) {
        //EditText campo1 = (EditText) findViewById(R.id.textValor1);
    }
}
