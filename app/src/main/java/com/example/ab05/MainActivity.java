package com.example.ab05;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer = new Timer();
    private ImageView imageView;
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private int hoehe = 800;
    private int breite = 800;
    private int textsize = 50;

    //Ball grenzen
    int grenzeLinks = 30;
    int grenzeRechts = 770;
    int grenzeOben = 400;
    int grenzeUnten = 770;

    //Ball größe
    int ballRadius = 20;
    float ballX = 100f;
    float ballY = 700f;
    float velociteX = 0.3f;
    float velociteY = 4.5f;

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
        //this.halloWelt();
        //this.halloNachbarn();
        //this.zeichneSmiley(200);

        this.timer.schedule(
                new TimerTask(){
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void run() {
                        derSpringendePunkt();
                    }
                }
                ,0,17 );

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
        this.paint.setStyle(Paint.Style.FILL);
        this.canvas.drawCircle(breite/2, hoehe/2, radius,this.paint);

        this.paint.setColor(Color.BLACK);
        float eyeYPosition = (float) ((hoehe/2)/1.2);
        float leftEyeXPosition = (float) ((breite/2)/1.2);
        float rightEyeXPosition = (float) ((breite)/1.6);
        this.canvas.drawCircle(leftEyeXPosition,eyeYPosition,25,this.paint);
        this.canvas.drawCircle(rightEyeXPosition,eyeYPosition,25,this.paint);


        RectF rect = new RectF(leftEyeXPosition, (hoehe + hoehe) /8, rightEyeXPosition, (float) ((hoehe + hoehe) / 3));
        canvas.drawArc(rect,10,150,false,this.paint);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void derSpringendePunkt(){
        this.paint.setColor(Color.BLUE);
        this.paint.setStrokeWidth(ballRadius);
        this.paint.setStyle(Paint.Style.FILL);
        this.canvas.drawCircle(ballX,ballY,ballRadius,this.paint);
        this.paint.setColor(Color.GREEN);
        this.ballY += this.velociteY;
        this.ballX += this.velociteX;
        this.canvas.drawCircle(ballX,ballY,ballRadius,this.paint);
        this.imageView.invalidate();

        if(ballY <= grenzeUnten){

            this.velociteY*=(-1);
        }
        if(ballY >= grenzeOben-400){
            this.velociteX*=(-1);
            this.velociteY*=(-1);
        }
        if(ballX <= grenzeLinks){
            this.velociteX*=(-1);
        }
        if(ballX >= grenzeRechts){
            this.velociteX*=(-1);
        }
    }
}
