package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;

public class Victory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);
        TextView textView = (TextView)findViewById(R.id.text) ;
        Typeface typeface = Typeface.createFromAsset(getAssets(),"verdana.ttf");
        textView.setTypeface(typeface);

MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.hallelluja);
        mediaPlayer.start();
        getIntent().getLongExtra("score",0);

        ImageView img = (ImageView)findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    Intent intent = new Intent(Victory.this, Scores.class);
                    startActivity(intent);
                }
            }
        });
    }
}
