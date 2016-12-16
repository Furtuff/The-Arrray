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
    MediaPlayer mediaPlayer;

    public static final String COUNTDOWN_BR = "your_package_name.countdown_br";
    Intent bi = new Intent(COUNTDOWN_BR);

    CountDownTimer cdt = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.thearraytheme);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        mediaPlayer.start();
        Log.i(TAG, "Starting timer...");

        cdt = new CountDownTimer(180000, 20) {
            @Override

            public void onTick(long millisUntilFinished) {

                Log.i(TAG, "Countdown seconds remaining: " + millisUntilFinished / 1000);

                bi.putExtra("countdown", millisUntilFinished);

                sendBroadcast(bi);
            }

            @Override
            public void onFinish() {
                Intent dialogIntent = new Intent(getApplicationContext(), GameOver.class);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
                Log.i(TAG, "Timer finished");
            }
        };

        cdt.start();
    }

    @Override
    public void onDestroy() {

        cdt.cancel();
        Log.i(TAG, "Timer cancelled");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
