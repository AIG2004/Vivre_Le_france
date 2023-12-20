package com.example.vivrelefrance;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class unit_4 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
Button quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4);
        quiz=findViewById(R.id.q4);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(unit_4.this, animals_test.class);
                startActivity(i);
            }
        });
    }

    public void playRabbitSound(View view) {
        playSound(R.raw.rabbit);
    }

    public void playLionSound(View view) {
        playSound(R.raw.lion);
    }

    public void playDogSound(View view) {
        playSound(R.raw.dog);
    }

    public void playCowSound(View view) {
        playSound(R.raw.cow);
    }

    public void playDonkeySound(View view) {
        playSound(R.raw.donkey);
    }

    private void playSound(int soundResource) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, soundResource);
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
