package com.example.minifitnessfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,cancel;
    EditText surendar,suren97;
    TextView text2;
    int counter = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        login = (Button)findViewById(R.id.login);
        surendar = (EditText)findViewById(R.id.surendar);
        suren97 = (EditText)findViewById(R.id.suren97);
        cancel = (Button)findViewById(R.id.cancel);
        text2 = (TextView)findViewById(R.id.text2);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (surendar.getText().toString().equals("surendar")&&
                        suren97.getText().toString().equals("suren97")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    openActivity2();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credential" ,Toast.LENGTH_SHORT).show();
                    text2.setVisibility(View.VISIBLE);
                    text2.setBackgroundColor(Color.YELLOW);
                    counter--;
                    text2.setText(Integer.toString(counter));
                    if (counter == 0) {
                        login.setEnabled(false);
                    }
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void openActivity2() {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}

