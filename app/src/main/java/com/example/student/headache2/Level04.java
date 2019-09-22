package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Database.Level4Handler;

public class Level04 extends AppCompatActivity {

    private ImageButton correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level04);

        Intent i = getIntent();
        final String username = i.getStringExtra("Username");

        correct=findViewById(R.id.imageButton2);
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext() , level04_game.class);
                intent.putExtra("UserName", username);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {

    }

}



