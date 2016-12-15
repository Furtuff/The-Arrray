package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageView;

public class Glotte extends AppCompatActivity {
    ImageView glotte;
    int sequence = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glotte);
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
                            startActivity(intent);
                            break;


                    }
                }
            }
        });
    }
}
