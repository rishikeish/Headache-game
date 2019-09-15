package com.example.student.headache2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.game_music);
        mediaPlayer.start();
    }

    public void sendMessage(View view){

        Intent intent = new Intent(this , Main2Activity.class);
        startActivity(intent);

    }


}
