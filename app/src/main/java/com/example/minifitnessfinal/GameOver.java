package com.example.minifitnessfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class GameOver extends AppCompatActivity {

    private Button StartGameAgain;
    private TextView DisplayScore;

    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        score = getIntent().getExtras().get("score").toString();




        StartGameAgain = (Button) findViewById(R.id.play_again_btn);

        DisplayScore = (TextView) findViewById(R.id.textView);

        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mainIntent = new Intent(GameOver.this, Rungame.class);
                startActivity(mainIntent);

            }
        });

        DisplayScore.setText("Score \n" + score);
    }
}