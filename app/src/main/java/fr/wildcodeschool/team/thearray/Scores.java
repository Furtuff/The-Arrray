package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Scores extends AppCompatActivity {
    TextView text;
    int count =0;
    String chier = "Your Score\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.chasseeau);
        mediaPlayer.start();
        long score = getIntent().getLongExtra("score",0);
        String v = String.format("%02d", score/60000);
        int va = (int)( (score%60000)/1000);
        String v2 = String.format("%02d",va);
        chier+=v+":"+v2;
        Typeface typeface = Typeface.createFromAsset(getAssets(),"impact.ttf");
        text = (TextView)findViewById(R.id.textView3);
        text.setTypeface(typeface);
        text.setTextSize(40);
        CountDownTimer cdt = null;

        cdt = new CountDownTimer(6250, 50) {
            @Override

            public void onTick(long millisUntilFinished) {
                if(count <= chier.length()) {
                    text.setText(chier.substring(0, count));
                    count++;
                }
            }

            @Override
            public void onFinish() {
                text.setText(chier);
            }
        };

        cdt.start();

        final Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    Intent intent = new Intent(Scores.this, Menu.class);
                    startActivity(intent);
                }
            }
        });
    }
}
