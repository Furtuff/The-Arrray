package fr.wildcodeschool.team.thearray;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicMenuService extends Service {
    public MusicMenuService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        super.onCreate();
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.fart_raspberry);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}
