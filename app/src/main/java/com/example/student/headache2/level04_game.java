package com.example.student.headache2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class level04_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level04_game);
    }

    protected void onClick(View view) {

        EditText editText = (EditText) findViewById(R.id.message);

        String text = editText.getText().toString();

        String correct = "this is the mad project";

        if (text == correct) {
            Toast.makeText(getApplicationContext(), "Right entry", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "wrong entry", Toast.LENGTH_SHORT).show();
        }
    }
}
