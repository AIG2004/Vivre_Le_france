package com.example.vivrelefrance;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*
 * family screen
 */
public class unit_3 extends AppCompatActivity   implements  View.OnClickListener{
    Button BTN1, BTN2,BTN3,BTN4,BTN5,BTN6,BTN7,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3);
        BTN1=findViewById(R.id.button1);
        BTN2=findViewById(R.id.button2);
        BTN3=findViewById(R.id.button3);
        BTN4=findViewById(R.id.button4);
        BTN5=findViewById(R.id.button5);
        BTN6=findViewById(R.id.button6);
        BTN7=findViewById(R.id.button);
        BTN1.setOnClickListener(this);
        BTN2.setOnClickListener(this);
        BTN3.setOnClickListener(this);
        BTN4.setOnClickListener(this);
        BTN5.setOnClickListener(this);
        BTN6.setOnClickListener(this);
        BTN7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
        // navigate to quiz
        Button toQuiz = findViewById(R.id.GoToQuizButton);
        toQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the Second Activity
                Intent intent = new Intent(unit_3.this, family_test.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        int clikedBtnClicked=v.getId();
        if(clikedBtnClicked==R.id.button1){
            playSound(R.raw.father);
            Toast.makeText(getApplicationContext(),"père", Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.button2) {
            playSound(R.raw.mother);
            Toast.makeText(getApplicationContext(),"mère", Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.button3) {
            playSound(R.raw.brother);
            Toast.makeText(getApplicationContext(),"frère", Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.button4) {
            playSound(R.raw.sisterr);
            Toast.makeText(getApplicationContext(),"sœur", Toast.LENGTH_SHORT).show();
        }else if(clikedBtnClicked==R.id.button5) {
            playSound(R.raw.grandfather);
            Toast.makeText(getApplicationContext(),"grand-pere", Toast.LENGTH_SHORT).show();
        }else {
            playSound(R.raw.grandmother);
            Toast.makeText(getApplicationContext(),"grand-mère", Toast.LENGTH_SHORT).show();
        }




    }

    public void playSound(int id){
        MediaPlayer mediaPlayer= MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }

    public  void Back(){
        Intent i=new Intent(this, Home_page.class);
        startActivity(i);

    }
}