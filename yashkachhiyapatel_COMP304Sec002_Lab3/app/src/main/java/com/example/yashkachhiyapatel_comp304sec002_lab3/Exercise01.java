package com.example.yashkachhiyapatel_comp304sec002_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

  //Line Drawing Activity
public class Exercise01 extends AppCompatActivity {
    Spinner spinner;  // spinner to store different thickness
    Button clear;      // clear the canvas
    ImageView up,down,left,right;  //4 clickable images to draw line in 4 directions

    private ImageView reusableImageView;
    private TextView textView;

    private int startx = 0;
    private int starty = 0;
    private int endx=0;
    private int endy=0;

    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    RadioGroup radioGroup;
    RadioButton redRadio;
    TextView x,y;

    int setColor = Color.RED;
    int lineThickness=15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise01);
        setTitle("Draw Line"); //setting title of the page
        //create the paint for our drawings
        paint = new Paint();
        paint.setColor(setColor);
        paint.setStrokeWidth(lineThickness);

        redRadio = findViewById(R.id.red);
        redRadio.setChecked(true);
        x = findViewById(R.id.xValue);
        y = findViewById(R.id.yValue);
        //default position of point with coordinates x and y
        x.setText("0");
        y.setText("0");

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.BLACK); //background
        //setup the image view
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);

        spinner = findViewById(R.id.lineThickness);

        //spinner to change line thickness and store that value in one global variable
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    lineThickness=15;
                }else if (position==1){
                    lineThickness=20;
                }else if (position==2){
                    lineThickness=25;
                }else if (position==3){
                    lineThickness=30;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        up = findViewById(R.id.upKey);
        down = findViewById(R.id.downKey);
        left = findViewById(R.id.leftKey);
        right = findViewById(R.id.rightKey);

        canvas.drawPoint(5,5,paint);
        //radio buttons to change the line color
        radioGroup = findViewById(R.id.lineColorGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.green){
                    setColor = Color.GREEN;
                }else  if (checkedId==R.id.red){
                    setColor= Color.RED;
                }else  if (checkedId==R.id.yellow){
                    setColor= Color.YELLOW;
                }
            }
        });

        //4 images to move in 4 directions
        // and same way change the coordinates
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy-20;
                drawLine( canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();
                paint.setColor(setColor);
                paint.setStrokeWidth(lineThickness);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy+20;
                drawLine( canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();
                paint.setColor(setColor);
                paint.setStrokeWidth(lineThickness);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-20;
                drawLine( canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();
                paint.setColor(setColor);
                paint.setStrokeWidth(lineThickness);
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+20;
                drawLine(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();
                paint.setColor(setColor);
                paint.setStrokeWidth(lineThickness);
            }
        });

        //clear button to erase the canvas and setting will be changed to default
        clear = findViewById(R.id.btnClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvas.drawColor(Color.BLACK);
                startx = 0;
                starty = 0;
                endx = 0;
                endy = 0;
                x.setText("0");
                y.setText("0");
                redRadio.setChecked(true);
                spinner.setSelection(0);
                reusableImageView.invalidate();
            }
        });

    }

    //after changing every direction, this function is called to drawline on canvas with coordinates
    public void drawLine(Canvas canvas)
    {
        x.setText(String.valueOf(endx));
        y.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;
    }

}