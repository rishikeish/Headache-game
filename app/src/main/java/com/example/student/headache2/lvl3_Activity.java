package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import Database.Level2Handler;
import Database.Level3Handler;

public class lvl3_Activity extends AppCompatActivity {
    
    Level3Handler db = new Level3Handler(this); //create database handling object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl3_);

    }

    public void sendMessage(View view){ //method for submit button

        Intent i = getIntent(); //create intent object
        final String username = i.getStringExtra("UserName"); //get player username

        Log.w("lola" , username); //log to check 

        //assign plain text/edit text values to string to read
        EditText a1 = findViewById(R.id.ans1);
        String answer1 = a1.getText().toString(); //1st answer

        EditText a2 = findViewById(R.id.ans2);
        String answer2 = a2.getText().toString(); //2nd answer

        EditText a3 = findViewById(R.id.ans3);
        String answer3 = a3.getText().toString(); //3rd answer

        //validation - if else 
        if (TextUtils.isEmpty(answer1) || TextUtils.isEmpty(answer2) || TextUtils.isEmpty(answer3)){
            Toast warn = Toast.makeText(getApplicationContext(), "Enter Answers To Advance", Toast.LENGTH_LONG); //create toast message
            warn.show(); //display message
        } //check for empty fields

        else if (checkAnswer(answer1) && checkAnswer(answer2) && checkAnswer(answer3)){ //compare answers with read values
            Toast congrat = Toast.makeText(getApplicationContext(),"All Answers Are Successful! You May Advance To The Next Level!", Toast.LENGTH_LONG); //create toast
            congrat.show(); //display message
            //redirect to the next level
            Intent intent = new Intent(this , Level04.class); //ctreate intent 
            intent.putExtra("UserName", username); //assign username to intent
            startActivity(intent);

        } //check for successful answers

        else {
            Toast fail = Toast.makeText(getApplicationContext(),"Incorrect Answers. Please Try Again To Advance To The Next Level.", Toast.LENGTH_LONG); //create toast
            fail.show();//display toast message

            Intent intent = new Intent(this, lvl3_Activity.class); //redirect to the same level
            startActivity(intent); 

        } //check for incorrect answers

    }

    //method to check answer
    public boolean checkAnswer(String answer){
        //list to read answers
        List<String> list =  db.readAnswers(); //readAnswer method used to fetch table data
        //for loop
        for (String a : list){
            if(answer.equalsIgnoreCase(a))//compare answers with table data to be equal
                return true; 
        } //end of for loop

        return false; //return false if not found
    }//end of check answer method

    @Override
    public void onBackPressed() { //prevent return button

    }

}
