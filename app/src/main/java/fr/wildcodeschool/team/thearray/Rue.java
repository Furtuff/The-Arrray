package fr.wildcodeschool.team.thearray;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Rue extends AppCompatActivity {
TextView chrono;
    TextView text;
    int count =0;
    String chier = "IL FAUT QUE J'AILLE CHIER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rue);
        startService(new Intent(this, BroadcastService.class));
        text = (TextView)findViewById(R.id.text);
        CountDownTimer cdt = null;

        cdt = new CountDownTimer(18000, 80) {
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
                    Intent intent = new Intent(Rue.this, Entree.class);
                    unregisterReceiver(br);
                    startActivity(intent);
                }
            }
        });
        registerReceiver(br,new IntentFilter(BroadcastService.COUNTDOWN_BR));
    chrono = (TextView)findViewById(R.id.chrono);
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //if (isDoneOnce) {
            getTime(intent);
            //    isDoneOnce = false;
            // }
        }
    };
    public void getTime(Intent intent){
        if (intent.getExtras() != null){
            long time = intent.getLongExtra("countdown", 0);
            String v = String.format("%02d", time/60000);
            int va = (int)( (time%60000)/1000);
            chrono.setText(v + ":" +String.format("%02d",va));
        }
    }
}