package fr.wildcodeschool.team.thearray;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Medic extends AppCompatActivity {
    TextView chrono;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medic);

        final ImageView imgdoc = (ImageView) findViewById(R.id.med);
        imgdoc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    switch (count){
                        case 0: imgdoc.setImageResource(R.drawable.pillule);
                        count ++;
                            break;
                        case  1: Intent intent = new Intent(Medic.this, Glotte.class);
                            unregisterReceiver(br);
                            finish();
                            startActivity(intent);
                            break;
                    }



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
