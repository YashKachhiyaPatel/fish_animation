package com.example.yashkachhiyapatel_comp304_002_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

//first page to display list of exercises
public class MainActivity extends AppCompatActivity {

    TextView title;  // title of page
    Spinner spinner; // display exercises
    String exercise; //store name of exercise
    int exerciseKcal = 0, exerciseColor = Color.BLUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.textTitle);
        spinner = findViewById(R.id.listItems);

        //make default selection false
        spinner.setSelection(0,false);
        //set title of page
        title.setText(R.string.info);

        //spinner to select value of exercise and move to next activity
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int chosenPosition = position;

                //assign values to variable accroding to selected position
                 if(chosenPosition == 1){
                     exercise = getString(R.string.JumpingRope);
                     exerciseKcal = 750;
                     exerciseColor = Color.BLUE;
                 }
                 else if(chosenPosition == 2){
                     exercise = getString(R.string.Swimming);
                     exerciseKcal = 600;
                     exerciseColor = Color.RED;
                 }
                 else if(chosenPosition == 3){
                     exercise = getString(R.string.BikeRiding);
                     exerciseKcal = 500;
                     exerciseColor = Color.YELLOW;
                 }
                 else if(chosenPosition == 4){
                     exercise = getString(R.string.Walking);
                     exerciseKcal = 300;
                     exerciseColor = Color.GREEN;
                 }
                 else if(chosenPosition == 5){
                     exercise = getString(R.string.Running);
                     exerciseKcal = 600;
                     exerciseColor = 0xFF800080;
                 }

                 //intent to move to next page, after storing values in variables
                Intent intent = new Intent(getApplicationContext(),graphActivity.class);
                 intent.putExtra("exerciseName", exercise);
                 intent.putExtra("exerciseValue",exerciseKcal);
                intent.putExtra("ColorValue",exerciseColor);
                //start next activity
                 startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}