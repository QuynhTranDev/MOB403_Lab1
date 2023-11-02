package com.example.mob403_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai2 extends AppCompatActivity implements View.OnClickListener {

    private String url = "https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png";
    private ImageView imageView2;
    private TextView textView2;
    private Button btnB2;
    private Bitmap bitmap = null;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        imageView2 = (ImageView) findViewById(R.id.imageViewB2);
        textView2= (TextView) findViewById(R.id.textViewB2);
        btnB2 = (Button) findViewById(R.id.btnB2);
        btnB2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        progressDialog = ProgressDialog.show(Bai2.this, "","Downloading...");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = downloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMessage = "Image Downloaded";
                bundle.putString("a", threadMessage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("a");
            textView2.setText(message);
            imageView2.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

    private Bitmap downloadBitmap(String link) {
        try {
            URL url1 = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
            return bitmap1;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}