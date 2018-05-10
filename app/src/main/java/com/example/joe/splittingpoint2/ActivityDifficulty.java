package com.example.joe.splittingpoint2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDifficulty extends AppCompatActivity {

    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPlayBoxNormal();
            }
        });

        button2 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                openActivityPlayBoxEasy();
            }
        });
    }

    public void  openActivityPlayBoxNormal() {
        Intent intent = new Intent(this, ActivityPlayBox.class);
        intent.putExtra("difficulty", 5);
        startActivity(intent);
    }

    public void  openActivityPlayBoxEasy() {
        Intent intent2 = new Intent(this, ActivityPlayBox.class);
        intent2.putExtra("difficulty", 45);
        startActivity(intent2);
    }
}