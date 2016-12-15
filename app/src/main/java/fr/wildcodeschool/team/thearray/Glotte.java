package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import pl.droidsonroids.gif.GifImageView;

public class Glotte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glotte);

        GifImageView gifview = (GifImageView)findViewById(R.id.gif);
        gifview.setImageResource(R.drawable.gif1);

        gifview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    Intent intent = new Intent(Glotte.this, Vomi.class);
                    startActivity(intent);
                }
            }
        });
    }
}
