package fr.wildcodeschool.team.thearray;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class Dragporte extends AppCompatActivity {
TextView chrono;
    long score ;
    TextView text;
    int count =0;
    String chier = "La porte est bloquée!\nFaut que je rentre.\nJe dois l'ouvrir vite ou c'est la cata... Je ramasse un tournevis par terre.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragporte);
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

        // creating DragLinearLayout to use drag&drop
        DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);
        // set childs dragable
        for (int i = 0; i < dragLinearLayout.getChildCount(); i++) {
            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child);
        }
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
                {
                    Intent intent = new Intent(Dragporte.this, Victory.class);
                    stopService(new Intent(Dragporte.this, BroadcastService.class));
                    intent.putExtra("score", score);
                    unregisterReceiver(br);
                    finish();
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
            score = time;
            String v = String.format("%02d", time/60000);
            int va = (int)( (time%60000)/1000);
            chrono.setText(v + ":" +String.format("%02d",va));
        }
    }
}
