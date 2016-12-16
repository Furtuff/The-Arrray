package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

            GifImageView gifview = (GifImageView)findViewById(R.id.gif);
            gifview.setImageResource(R.drawable.gameover);
            stopService(new Intent(getApplicationContext(),BroadcastService.class));
        MediaPlayer mediaPlayer1 = MediaPlayer.create(this,R.raw.gameover_fart);
        mediaPlayer1.start();
            gifview.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View V){
                    {
                        Intent intent = new Intent(GameOver.this, Menu.class);
                        startActivity(intent);
                    }
                }
            });
    }
}
