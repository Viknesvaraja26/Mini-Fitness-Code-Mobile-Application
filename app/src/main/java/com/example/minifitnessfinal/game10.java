package com.example.minifitnessfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class game10 extends AppCompatActivity {

    private Game hunton;
    private MediaPlayer mediaPlayer;

    private Handler handler = new Handler();
    private final static long Interval = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hunton = new Game(this);

        setContentView(hunton);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        hunton.invalidate();
                    }
                });
            }
        }, 0, Interval);

        mediaPlayer = MediaPlayer.create(game10.this, R.raw.song);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}