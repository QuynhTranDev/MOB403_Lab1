package com.example.mob403_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4 extends AppCompatActivity implements View.OnClickListener {

    Button btnB4;
    TextView tvResult;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        btnB4 = (Button) findViewById(R.id.btnB4);
        tvResult = (TextView) findViewById(R.id.tvResult);
        editText = (EditText) findViewById(R.id.edText);
        btnB4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(tvResult, editText, this);
        String sleepTime = editText.getText().toString();
        asyncTaskRunner.execute(sleepTime);
    }
}