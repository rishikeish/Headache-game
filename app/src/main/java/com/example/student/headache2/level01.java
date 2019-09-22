package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.*;

import Database.Level1Handler;



public class level01 extends AppCompatActivity {

    private ImageButton check;

    Level1Handler db = new Level1Handler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level01);



        check = findViewById(R.id.lvl1submit);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edit1 = findViewById(R.id.word1);
                String answer1 = edit1.getText().toString();

                EditText edit2 = findViewById(R.id.word2);
                String answer2 = edit2.getText().toString();

                EditText edit3 = findViewById(R.id.word3);
                String answer3 = edit3.getText().toString();

                EditText edit4 = findViewById(R.id.word4);
                String answer4 = edit4.getText().toString();

                if (isEmpty(answer1)|| isEmpty(answer2)|| isEmpty(answer3)|| isEmpty(answer4)){
                    Toast t = Toast.makeText(getApplicationContext(), "You Must Enter All 4 Answers!", Toast.LENGTH_SHORT);
                    t.show();
                }else if(correct(answer1) && correct(answer2) && correct(answer3) && correct(answer4)){

                    Toast t = Toast.makeText(getApplicationContext() , "You Have Entered All Answers Correctly" , Toast.LENGTH_SHORT);
                    t.show();

                    Intent intent = new Intent(getApplicationContext(),Level2_Activity.class);
                    startActivity(intent);
                }else{
                    Toast t = Toast.makeText(getApplicationContext() , "Entered Answers Are Not Correct" , Toast.LENGTH_SHORT);
                    t.show();

                    Intent intent = new Intent(getApplicationContext(),level01.class);
                    startActivity(intent);
                }
            }
        });

    }


    public boolean correct(String word){

        Log.w("TAG" , word );
        List<String> list =  db.readAnswers();

        for(String ans : list){
            Log.w("mega" , "for loop runs" );
            Log.w("answer" , ans );
            if(word.equalsIgnoreCase(ans)){
                return true;
            }
        }
        return false;
    }

    boolean isEmpty(String text) {

        return TextUtils.isEmpty(text);
    }

    @Override
    public void onBackPressed() {

    }

}
