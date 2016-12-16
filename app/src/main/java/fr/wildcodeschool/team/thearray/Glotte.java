package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Glotte extends AppCompatActivity {
    ImageView glotte;
    int sequence = 1;
    TextView text;
    int count =0;
    String chier = "Merde, je sais pas ce que\nj'ai bouffé mais faut\nabsolument que j'aille chier...\nTiens là, The Array, il doit y avoir des W.C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glotte);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"verdana.ttf");
        text = (TextView)findViewById(R.id.text);
        text.setTypeface(typeface);
        text.setTextSize(18);
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
        glotte = (ImageView)findViewById(R.id.glotte);

        glotte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    switch (sequence) {
                        case 1: glotte.setImageResource(R.drawable.glotte02);
                                sequence ++;
                            break;
                        case 2: glotte.setImageResource(R.drawable.glotte03);
                            sequence++;
                            break;
                        case 3: glotte.setImageResource(R.drawable.glotte01);
                            sequence++;
                            break;
                        case 4: glotte.setImageResource(R.drawable.glotte02);
                            sequence++;
                            break;
                        case 5: glotte.setImageResource(R.drawable.glotte03);
                            sequence++;
                            Intent intent = new Intent(Glotte.this, Vomi.class);
                           finish();
                            startActivity(intent);
                            break;


                    }
                }
            }
        });
    }
}
