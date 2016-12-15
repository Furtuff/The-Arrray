package fr.wildcodeschool.team.thearray;

import android.app.Service;
import android.content.Intent;
import android.icu.util.TimeUnit;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

public class BroadcastService extends Service {
    private final static String TAG = "BroadcastService";
    long cyclic = 180000;

    public static final String COUNTDOWN_BR = "your_package_name.countdown_br";
    Intent bi = new Intent(COUNTDOWN_BR);

    CountDownTimer cdt = null;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "Starting timer...");

        cdt = new CountDownTimer(180000, 1000) {
            @Override

            public void onTick(long millisUntilFinished) {

                Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished / 1000);
                bi.putExtra("countdown", millisUntilFinished);
                if (java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)== java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(cyclic)-20){
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.fart_raspberry);
                    mediaPlayer.start();
                    cyclic = millisUntilFinished;

                }
                sendBroadcast(bi);
            }

            @Override
            public void onFinish() {
                Log.i(TAG, "Timer finished");
            }
        };

        cdt.start();
    }

    @Override
    public void onDestroy() {

        cdt.cancel();
        Log.i(TAG, "Timer cancelled");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
