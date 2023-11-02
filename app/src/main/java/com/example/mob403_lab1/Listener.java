package com.example.mob403_lab1;

import android.graphics.Bitmap;

public interface Listener {
    void onImageLoaded(Bitmap bitmap);
    void onError();
}
