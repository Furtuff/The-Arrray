package fr.wildcodeschool.team.thearray;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView chrono = (TextView)findViewById(R.id.chrono);
        CountDownTimer cT =  new CountDownTimer(180000, 1000) {

            public void onTick(long millisUntilFinished) {


                String v = String.format("%02d", millisUntilFinished/60000);
                int va = (int)( (millisUntilFinished%60000)/1000);
                chrono.setText("seconds remaining: " +v+":"+String.format("%02d",va));
            }

            public void onFinish() {
                chrono.setText("done!");
            }
        };
        cT.start();




    }
}
