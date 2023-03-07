package com.example.timekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int number;
    Handler handler;
    Runnable runnable;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.startButton);
        textView = findViewById(R.id.textView3);


        number = 0;

    }

    public void start (View view) {

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Left: " +number);
                number++;
                textView.setText("Left:" +number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);



    }

    public void stop (View view) {

        button.setEnabled(true);

        handler.removeCallbacks(runnable);
        number = 0;
        textView.setText("Left:" +number);




    }
}