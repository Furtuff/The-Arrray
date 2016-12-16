package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;

public class Poignee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poignee);

        GifImageView gifview = (GifImageView)findViewById(R.id.gif);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.fart_raspberry);
        gifview.setImageResource(R.drawable.portebloque);

        gifview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    Intent intent = new Intent(Poignee.this, Dragporte.class);
                    startActivity(intent);
                }
            }
        });
    }
}
