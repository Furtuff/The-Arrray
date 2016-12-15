package fr.wildcodeschool.team.thearray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class Dragporte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragporte);
       // creating DragLinearLayout to use drag&drop
        DragLinearLayout dragLinearLayout = (DragLinearLayout) findViewById(R.id.container);
        // set childs dragable
        for (int i = 0; i < dragLinearLayout.getChildCount(); i++) {
            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child);
        }
    }
}
