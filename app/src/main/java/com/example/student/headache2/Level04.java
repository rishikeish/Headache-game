package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Level04 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level04);
    }

    protected void onClick(View view){

        Intent intent = new Intent(this , level04_game.class);
        startActivity(intent);


    }

    @Override
    public void onBackPressed() {

    }
}
