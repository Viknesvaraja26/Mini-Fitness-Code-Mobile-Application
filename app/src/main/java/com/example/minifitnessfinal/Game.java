package com.example.minifitnessfinal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class Game extends View {

    private Bitmap fish[] = new Bitmap[2];

    private int X = 10;
    private int Y;
    private int Fspeed;

    private int canvasWidth, canvasHeihgt;

    private Bitmap backgrondImage;

    private Bitmap pausebut;

    private Paint scorepaint = new Paint();

    private Bitmap life[] = new Bitmap[2];

    // Yello Ball

    private int yellowX , yellowY , yellowSpeed = 16;
    private Paint yellowPaint = new Paint();

    // Green Ball

    private int greenX , greenY , greenSpeed = 20;
    private Paint greenPaint = new Paint();

    // Red Ball

    private int redX , redY , redSpeed = 25;
    private Paint redPaint = new Paint();


    private int score , lifeCounter;

    private boolean touch = false;


    public Game(Context context) {
        super(context);

        fish[0] = BitmapFactory.decodeResource(getResources(), R.drawable.fish);
        fish[1] = BitmapFactory.decodeResource(getResources(), R.drawable.fish2);

        backgrondImage = BitmapFactory.decodeResource(getResources(), R.drawable.background);

        // Yellow
        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setAntiAlias(false);


        // Green
        greenPaint.setColor(Color.GREEN);
        greenPaint.setAntiAlias(false);

        //Red
        redPaint.setColor(Color.RED);
        redPaint.setAntiAlias(false);


        scorepaint.setColor(Color.RED);
        scorepaint.setTextSize(75);
        scorepaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorepaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.hearts);
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heart_grey);

        pausebut = BitmapFactory.decodeResource(getResources(), R.drawable.pause);

        Y = 650;
        score = 0;
        lifeCounter = 3;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeihgt = canvas.getHeight();


        canvas.drawBitmap(backgrondImage , 0 ,0 , null);

        int minY = fish[0].getHeight();
        int maxY = canvasHeihgt - fish[0].getHeight() * 4;

        Y = Y + Fspeed;

        if (Y < minY){
            Y = minY;
        }
        if (Y > maxY){
            Y = maxY;
        }

        Fspeed = Fspeed + 3;

        if (touch){
            canvas.drawBitmap(fish[1],X , Y , null);
            touch = false;

        }

        else{
            canvas.drawBitmap(fish[0],X , Y , null);
        }


// Yellow ball function

        yellowX = yellowX - yellowSpeed;

        if (hitBall(yellowX , yellowY)){
            score = score + 10;
            yellowX = - 100;
        }

        if (yellowX < 0){
            yellowX = canvasWidth + 21;
            yellowY = (int) Math.floor(Math.random() * (maxY - minY)) + minY;
        }
        canvas.drawCircle(yellowX, yellowY, 25 , yellowPaint);

// Green ball function

        greenX = greenX - greenSpeed;

        if (hitBall(greenX , greenY)){
            score = score + 20;
            greenX = - 100;
        }

        if (greenX < 0){
            greenX = canvasWidth + 21;
            greenY = (int) Math.floor(Math.random() * (maxY - minY)) + minY;
        }
        canvas.drawCircle(greenX, greenY, 25 , greenPaint);

// Red Ball Function

        redX = redX - redSpeed;

        if (hitBall(redX , redY)){
            redX = - 100;
            lifeCounter--;

            if (lifeCounter == 0){
                Toast.makeText(getContext(), "Game Over" , Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(), GameOver.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gameOverIntent.putExtra("score" , score);
                getContext().startActivity(gameOverIntent);

            }
        }

        if (redX < 0){
            redX = canvasWidth + 23;
            redY = (int) Math.floor(Math.random() * (maxY - minY)) + minY;
        }
        canvas.drawCircle(redX, redY, 42 , redPaint);

        //pause button
        canvas.drawBitmap(pausebut, 880, 1760, null);



        // Score Function

        canvas.drawText("My Score : " + score ,20 ,60,scorepaint);

        // Red ball life decreasing function
        for (int i=0; i<3; i++){
            int x = (int) (580 + life[0].getWidth() * 1.5 * i);
            int y = 30;

            if (i < lifeCounter){
                canvas.drawBitmap(life[0] , x , y , null);
            }
            else{
                canvas.drawBitmap(life[1] , x , y , null);
            }

        }


    }

    public boolean hitBall(int x, int y){
        if (X < x && x < (X + fish[0].getWidth()) && Y < y && y < (Y + fish[0].getHeight())){
            return  true;
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            touch = true;

            Fspeed = -22;
        }
        return true;
    }


}
