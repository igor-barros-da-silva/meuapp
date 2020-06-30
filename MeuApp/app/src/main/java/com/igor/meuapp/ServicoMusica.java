package com.igor.meuapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ServicoMusica extends Service {

    MediaPlayer MyReprodutor;

    public void onCreate() {
        super.onCreate();
        myReprodutor = MediaPlayer.create(this, R.raw.musica);
        myReprodutor.setLooping(true);
        myReprodutor.setVolume(true);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        myReprodutor.start();
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();

        if(myReprodutor.isPlayins()) myReprodutor.stop();

        myReprodutor.release();
        myReprodutor = null;
    }

    @Nullable
    @Override
    public IBinder onBlind(Intent intent){
        return null;
    }
}
