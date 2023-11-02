package com.example.mob403_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnB1, btnB2, btnB3, btnB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnB1 = (Button) findViewById(R.id.btnB1);
        btnB2 = (Button) findViewById(R.id.btnB2);
        btnB3 = (Button) findViewById(R.id.btnB3);
        btnB4 = (Button) findViewById(R.id.btnB4);

        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bai1.class);
                startActivity(intent);
                finish();
            }
        });

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bai2.class);
                startActivity(intent);
                finish();
            }
        });

        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bai3.class);
                startActivity(intent);
                finish();
            }
        });

        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Bai4.class);
                startActivity(intent);
                finish();
            }
        });
    }
}