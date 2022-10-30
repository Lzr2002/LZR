package com.example.mymusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private Mybinder binder;
    private MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("JOJO","MyService onCreate...");
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
        mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("JOJO","MyService onStartCommand...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("JOJO","MyService onDestroy...");
        mediaPlayer.stop();
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.d("JOJO","MyService onBind...");
        binder=new Mybinder();
        return binder;
    }

    class Mybinder extends Binder{
        public void myplay() {
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music1);
            mediaPlayer.start();
            Log.d("JOJO","MyService Mybinder...");
        }
    }
}
