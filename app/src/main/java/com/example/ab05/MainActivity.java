package com.example.ab05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
    private int textsize = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bitmap = Bitmap.createBitmap(this.breite, this.hoehe, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(this);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
        setContentView(imageView);
        this.canvas.drawColor(Color.argb(255, 0, 0, 255));
        this.paint.setTextSize(textsize);
        this.halloWelt();
        this.halloNachbarn();
        //this.zeichneSmiley(100);

    }
    private void halloNachbarn(){
        textZentrieren("Hallo Maxi und Tom!", 150);
    }

    private void halloWelt() {
        String text = "Hallo Welt!";
        float textWidth = this.paint.measureText(text);
        this.paint.setColor(Color.WHITE);
        this.canvas.drawText(text, breite / 2 - textWidth / 2, 100, this.paint);
    }
    private void textZentrieren(String text, int y){
        float textWidth = this.paint.measureText(text);
        this.canvas.drawText(text, breite / 2 - textWidth / 2, y, this.paint);
    }
    public void zeichneSmiley(int radius){
        this.paint.setColor(Color.GREEN);
        this.paint.setStrokeWidth(radius);
        this.paint.setStyle(Paint.Style.STROKE);
        this.canvas.drawCircle(hoehe/2, breite/2, radius,this.paint);
    }
}
