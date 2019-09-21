package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Classes.Level1;
import Database.Level2Handler;

public class Level2_Activity extends AppCompatActivity {

    Level2Handler db = new Level2Handler(this);
    Button check ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2_);

        check = findViewById(R.id.lvl2submit);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edit1 = findViewById(R.id.answer1);
                String answer1 = edit1.getText().toString();


                if (isEmpty(answer1)){
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter answer!", Toast.LENGTH_SHORT);
                    t.show();
                }else if(correct(answer1)){

                    Toast t = Toast.makeText(getApplicationContext() , "You have entered  correctly" , Toast.LENGTH_SHORT);
                    t.show();

                    Intent intent = new Intent(getApplicationContext(),lvl3_Activity.class);
                    startActivity(intent);
                }else{
                    Toast t = Toast.makeText(getApplicationContext() , "Entered answers are not correct" , Toast.LENGTH_SHORT);
                    t.show();

                    Intent intent = new Intent(getApplicationContext(),Level2_Activity.class);
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
            if(word.equalsIgnoreCase(ans)){
                return true;
            }
        }
        return false;
    }

    boolean isEmpty(String text) {

        return TextUtils.isEmpty(text);
    }
}


