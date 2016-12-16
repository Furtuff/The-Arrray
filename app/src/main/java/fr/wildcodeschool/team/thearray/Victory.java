package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Victory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.hallelluja);
        mediaPlayer.start();
        getIntent().getLongExtra("score",0);
    }
}
