package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHandler;
import Database.Level4Handler;

public class level04_game extends AppCompatActivity {



    private ImageButton correct;
    DBHandler db = new DBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level04_game);



        Intent i = getIntent();
        final String username = i.getStringExtra("Username");

        correct = findViewById(R.id.lvl4submit);
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edit1 = findViewById(R.id.message);
                String answer = edit1.getText().toString();

                if (isEmpty(answer)) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter answer to proceed!", Toast.LENGTH_SHORT);
                    t.show();
                }else if (correct(answer)) {

                    Toast t = Toast.makeText(getApplicationContext(), "You Have Entered The Right Answer", Toast.LENGTH_SHORT);
                    t.show();

                    int score = 40;

                    db.updateInfo(username , score);

                    Intent intent = new Intent(getApplicationContext(),level04_game.class);
                    intent.putExtra("UserName", username);
                    startActivity(intent);
                }else {

                    Toast t = Toast.makeText(getApplicationContext(), "The Answers Are Wrong", Toast.LENGTH_SHORT);
                    t.show();

                    Intent intent = new Intent(getApplicationContext(),level04_game.class);
                    startActivity(intent);
                }
            }

        });

    }

    public boolean correct(String word ){

        Log.w("TAG" , word );

        String question = "This is the mad project";

        if(word.equalsIgnoreCase(question)){
            return true;
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
