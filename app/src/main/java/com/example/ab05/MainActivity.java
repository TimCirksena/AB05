package com.example.ab05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private int hoehe = 800;
    private int breite = 800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.bitmap = Bitmap.createBitmap(this.breite, this.hoehe, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(this);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}