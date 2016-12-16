package fr.wildcodeschool.team.thearray;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        startService(new Intent(this,MusicMenuService.class));

        final Button btnlaunch = (Button) findViewById(R.id.launcher);
        btnlaunch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View V){
            {
                stopService(new Intent(getApplicationContext(),MusicMenuService.class));
                Intent intent = new Intent(Menu.this, Rue.class);
                startActivity(intent);
            }
        }
    });
}
    @Override
    public void onStart(){
        super.onStart();
        startService(new Intent(this,MusicMenuService.class));

    }
}