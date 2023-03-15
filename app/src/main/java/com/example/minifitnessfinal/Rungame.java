package com.example.minifitnessfinal;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Rungame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rungame);

        Button button = findViewById(R.id.startbut);
        button.setOnClickListener(v -> openMainActivity());

    }
    public void openMainActivity(){
        Intent intent = new Intent(this,game10.class);
        startActivity(intent);
    }
}