package com.example.minifitnessfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Button button1 = findViewById(R.id.button3);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button4);
        Button button4 = findViewById(R.id.button5);


        button1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View View) {
            Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();
            openchest();
        }
        });

button2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View View) {
                    Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();
                    openabs();
                }
});
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();
                openarm();
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                Toast.makeText(getApplicationContext(), "Simple Button 1", Toast.LENGTH_LONG).show();
                openleg();
            }
        });

    }

    public void openchest() {
        Intent intent = new Intent(this, chest.class);
        startActivity(intent);
    }

    public void openabs() {
        Intent intent = new Intent(this, abs.class);
        startActivity(intent);
    }

    public void openarm() {
        Intent intent = new Intent(this, arm.class);
        startActivity(intent);
    }

    public void openleg() {
        Intent intent = new Intent(this, leg.class);
        startActivity(intent);
    }
}