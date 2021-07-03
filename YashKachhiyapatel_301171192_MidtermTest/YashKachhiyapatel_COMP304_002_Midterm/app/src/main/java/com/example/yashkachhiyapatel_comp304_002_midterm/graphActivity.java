package com.example.yashkachhiyapatel_comp304_002_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//second page to display graph and legend
public class graphActivity extends AppCompatActivity {

    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    TextView title,legendColor,legendValue;
    ImageView reusableImg;
    String exercise;
    int exerciseValue, exerciseColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        legendColor = findViewById(R.id.legendColor);
        legendValue = findViewById(R.id.legendValue);
        title = findViewById(R.id.graphTitle);
        title.setText("Calories Burned Per Hour"); // title of second page
        paint = new Paint();
        //get the values of exercise from previous page using intent
        //store it in variables
        Intent intent = getIntent();
        exercise = intent.getStringExtra("exerciseName");
        exerciseValue = intent.getIntExtra("exerciseValue",0);
        exerciseColor = intent.getIntExtra("ColorValue",0);

        paint.setColor(exerciseColor);

        int height = (int) getResources().getDimension(R.dimen.img_height);
        int width = (int) getResources().getDimension(R.dimen.img_width);
        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.BLACK); //background
        //setup the image view
        reusableImg = (ImageView) findViewById(R.id.graphImg);
        //tell image view for the bitmap format/content
        reusableImg.setImageBitmap(bitmap);

        //draw rectaangle in the canvas
        //set name of exercise in it
        try {
            int rectHeight=100;
            int textSize = 60;
            canvas.drawRect(0, exerciseValue, width, exerciseValue + rectHeight, paint);
            paint.setTextSize(50);
            paint.setColor(Color.WHITE);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

            String[] name = getResources().getStringArray(R.array.exercisesList);
            canvas.drawText(exercise, 10, exerciseValue+textSize, paint);
            //set color and value of legend
            legendColor.setBackgroundColor(exerciseColor);
            legendValue.setText(exerciseValue + "kcal");
        }catch (Exception e){

        }
        reusableImg.invalidate();



    }
}