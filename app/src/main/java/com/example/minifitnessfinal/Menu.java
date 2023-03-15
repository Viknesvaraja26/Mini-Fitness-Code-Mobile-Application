package com.example.minifitnessfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton button1 = findViewById(R.id.simpleImageButtonHome);
        ImageButton button2 = findViewById(R.id.imageButton);
        ImageButton button3 = findViewById(R.id.imageButton2);
        ImageButton button4 = findViewById(R.id.imageButton4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simpleImageButtonHome:
                Toast.makeText(this, "WORKOUTS clicked", Toast.LENGTH_SHORT).show();
                openActivity2();
                break;
            case R.id.imageButton:
                Toast.makeText(this, "DIET tips clicked", Toast.LENGTH_SHORT).show();
                openActivity3();
                break;
            case R.id.imageButton2:
                Toast.makeText(this, "CALCULATOR clicked", Toast.LENGTH_SHORT).show();
                openActivity4();
                break;
            case R.id.imageButton4:
                Toast.makeText(this, "GAMES clicked", Toast.LENGTH_SHORT).show();
                openRungame();
                break;

        }
    }

    public void openActivity2() {
        Intent intent = new Intent(this, workout.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, diet.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, calculator.class);
        startActivity(intent);
    }

    public void openRungame() {
        Intent intent = new Intent(this, Rungame.class);
        startActivity(intent);
    }
}