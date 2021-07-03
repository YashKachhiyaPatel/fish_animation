package com.example.yashkachhiyapatel_comp304sec002_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// Frame by frame animation activity
public class Exercise02 extends AppCompatActivity {
    AnimationDrawable mframeAnimation = null;
    Button startBtn,stopBtn;  //start and stop animation button
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise02);
        setTitle("Fish Animation"); //setting title of the page
        startBtn = (Button) findViewById(R.id.ButtonStart);
        stopBtn = (Button) findViewById(R.id.ButtonStop);
        img = findViewById(R.id.img_fish);

        //start button to start animation
        //it will change every frame with in perticular time limit
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish1);
                BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish2);
                BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish3);
                BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish4);
                BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish5);
                BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish6);

                BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish7);
                BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.fish8);

                // Get the background, which has been compiled to an AnimationDrawable object.
                int reasonableDuration = 210;
                mframeAnimation = new AnimationDrawable();
                mframeAnimation.setOneShot(false);	// loop continuously
                mframeAnimation.addFrame(frame1, reasonableDuration);
                mframeAnimation.addFrame(frame2, reasonableDuration);
                mframeAnimation.addFrame(frame3, reasonableDuration);
                mframeAnimation.addFrame(frame4, reasonableDuration);
                mframeAnimation.addFrame(frame5, reasonableDuration);
                mframeAnimation.addFrame(frame6, reasonableDuration);
                mframeAnimation.addFrame(frame7, reasonableDuration);

                mframeAnimation.addFrame(frame8, reasonableDuration);
                mframeAnimation.addFrame(frame8, reasonableDuration);
                mframeAnimation.addFrame(frame8, reasonableDuration);
                img.setBackground(mframeAnimation);

                mframeAnimation.setVisible(true,true);
                mframeAnimation.start();
            }
        });

        //stop button to stop animation
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mframeAnimation.stop();
                mframeAnimation.setVisible(false,false);
            }
        });
    }
}