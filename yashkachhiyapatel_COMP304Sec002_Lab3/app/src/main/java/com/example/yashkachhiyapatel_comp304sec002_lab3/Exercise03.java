package com.example.yashkachhiyapatel_comp304sec002_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

//earth moves around sun animation page
public class Exercise03 extends AppCompatActivity {
    Button start;
    ImageView reuseableImg,sunImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise03);
        setTitle("Earth Animation");  //setting title of the page

        //set 2 animations(rotate and scale)
        Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        Animation animation2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grow);

        start = findViewById(R.id.btnStart);
        reuseableImg = findViewById(R.id.earthImg);
        sunImage = findViewById(R.id.sunImg);

        //start animation by clicking this button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = start.getText().toString();
                if(title.equals("start")){
                    start.setText("stop");
                    reuseableImg.startAnimation(animation1);
                    sunImage.startAnimation(animation2);
                }
                if(title.equals("stop")){
                    start.setText("start");
                    reuseableImg.clearAnimation();
                    sunImage.clearAnimation();
                }


            }
        });


    }
}