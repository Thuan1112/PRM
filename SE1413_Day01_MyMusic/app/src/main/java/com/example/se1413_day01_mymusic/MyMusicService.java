package com.example.se1413_day01_mymusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyMusicService extends Service {
    private MediaPlayer my_object;

    public MyMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        my_object = MediaPlayer.create(getApplicationContext(), R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        my_object.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        my_object.release();
    }
}