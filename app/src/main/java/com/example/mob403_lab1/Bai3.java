package com.example.mob403_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai3 extends AppCompatActivity implements View.OnClickListener, Listener {

    private TextView textView3;
    private Button btnB3;
    private ImageView imageView3;
    public static final String IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        textView3 = (TextView) findViewById(R.id.textViewB3);
        btnB3 = (Button) findViewById(R.id.btnB3);
        imageView3 = (ImageView) findViewById(R.id.imageViewB3);
        btnB3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new LoadImageTask(this,this).execute(IMAGE_URL);
    }


    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imageView3.setImageBitmap(bitmap);
        textView3.setText("Image Downloaded");
    }

    @Override
    public void onError() {
        textView3.setText("Error Download Image");
    }
}