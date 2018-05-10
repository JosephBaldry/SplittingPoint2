package com.example.joe.splittingpoint2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTitle extends AppCompatActivity {

    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() { // If Clicked
            @Override
            public void onClick(View v) {
                openActivityDifficulty();
            }
        });

        button2 = findViewById(R.id.button4);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                openActivityBoxSide();
            }
        });
    }

    // Go To Activity
    public void  openActivityDifficulty() {
        Intent intent = new Intent(this, ActivityDifficulty.class);
        startActivity(intent);
    }

    public void  openActivityBoxSide() {
        Intent intent3 = new Intent(this, ActivityBoxSide.class);
        startActivity(intent3);
    }
}
