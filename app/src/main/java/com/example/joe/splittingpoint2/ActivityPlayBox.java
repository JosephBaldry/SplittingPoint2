package com.example.joe.splittingpoint2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;


public class ActivityPlayBox extends AppCompatActivity
{
    boolean is_running = true;
    int game_speed = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_box);

        final int bar_size = getIntent().getExtras().getInt("difficulty");

        final ImageView player_square = findViewById(R.id.imgPlayer);
        final ImageView target_bar = findViewById(R.id.imgBar);
        target_bar.getLayoutParams().height = bar_size; // Set Height Of Target Bar
        target_bar.requestLayout();

        final Handler increase_size_handler = new Handler();
        increase_size_handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if(is_running)
                {
                    // Increase Height Of Rectangle
                    player_square.getLayoutParams().height = player_square.getHeight() + 5;
                    player_square.requestLayout();

                    // Calculate The Distance
                    ImageView win_square = findViewById(R.id.imgTarget);
                    TextView distance = findViewById(R.id.txtDistance);
                    float current_distance_h = win_square.getHeight() - player_square.getHeight();
                    distance.setText("Distance: " + current_distance_h);
                }

                if(!is_running) // User Has Touched Screen
                {
                    float hPlayer = player_square.getY();
                    float hBar = target_bar.getY();
                    TextView win = findViewById(R.id.txtWin);

                    if(hPlayer >= hBar && hPlayer <= hBar + target_bar.getHeight())
                    {
                        win.setText("You Win!");
                    }
                }
                increase_size_handler.postDelayed(this, game_speed);
            }
        }, game_speed);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int event_action_type = event.getAction();

        // Screen Is Touched
        if(event_action_type == MotionEvent.ACTION_DOWN)
        {
            is_running = false;
        }
        return true;
    }
    }
