package com.example.joe.splittingpoint2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityBoxSide extends AppCompatActivity {
    boolean is_running = true;
    int game_speed = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_side);
        final ImageView player_square = findViewById(R.id.imgPlayer);
        final ImageView target_bar = findViewById(R.id.imgBar);

        final Handler increase_size_handler = new Handler();
        increase_size_handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(is_running)
                {


                    // Increase Height Of Rectangle
                    player_square.getLayoutParams().width = player_square.getWidth() + 5;
                    player_square.requestLayout();

                    // Calculate The Distance
                    ImageView win_square = findViewById(R.id.imgTarget);
                    TextView distance = findViewById(R.id.txtDistance);
                    float current_distance_w = win_square.getWidth() - player_square.getWidth();
                    distance.setText("Distance: " + current_distance_w);

                }

                if(!is_running)
                {

                    float hPlayer = player_square.getX();
                    float hBar = target_bar.getX();
                    TextView win = findViewById(R.id.txtWin);

                    if(hPlayer >= hBar && hPlayer <= hBar + target_bar.getWidth())
                    {
                        win.setText("You Win!");
                    }
                }
                increase_size_handler.postDelayed(this, game_speed);
            }
        }, game_speed);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int event_action_type = event.getAction();

        // Screen Is Touched
        if(event_action_type == MotionEvent.ACTION_DOWN) {
            is_running = false;


        }

        return true;
    }}
