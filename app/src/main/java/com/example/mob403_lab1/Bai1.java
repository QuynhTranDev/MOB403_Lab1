package com.example.mob403_lab1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.URL;

public class Bai1 extends AppCompatActivity implements View.OnClickListener {

    Button btnB1;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        btnB1 = (Button) findViewById(R.id.btnB1);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        btnB1.setOnClickListener(this);

    }

    private Bitmap loadImageFromNetwork (String link) {
        URL url;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    public void onClick(View view) {
        final Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImageFromNetwork("https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png");
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Image Downloaded");
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });
        myThread.start();
    }
}