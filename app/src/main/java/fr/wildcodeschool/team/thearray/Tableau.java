package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.felipecsl.gifimageview.library.GifImageView;

public class Tableau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau);

        GifImageView gifImageView = (GifImageView)findViewById(R.id.gif);
        gifImageView.setImageResource(R.drawable.gif1);

        final GifImageView gifImageView1 = (GifImageView)findViewById(R.id.gif);
        gifImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    Intent intent = new Intent(Tableau.this, Wcporte.class);
                    startActivity(intent);
                }
            }
        });
    }
}
