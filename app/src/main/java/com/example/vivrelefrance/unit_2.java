package com.example.vivrelefrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// we created a dicrictory called raw in res and putted in it the .mp3 files ,we can acces the files in it by id
// we implemted this interterface cuase we want to refactor our code
public class unit_2 extends AppCompatActivity implements View.OnClickListener {
    Button redBTN,yellowBTN,balckBTN,purpelBTN,greenBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2);
        redBTN=findViewById(R.id.redBTN);
        yellowBTN=findViewById(R.id.yellowBTN);
        balckBTN=findViewById(R.id.blackBTN);
        purpelBTN=findViewById(R.id.purpelBTN);
        greenBTN=findViewById(R.id.greenBTN);
        //
//        redBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // it's a class allwo us th play sound
//                // we can creat the obj. by new key word but it's better to do it with the static method creat
//                MediaPlayer mediaPlayer= MediaPlayer.create(
//                      //this is context  getApplicationContext(),
//                        R.raw.red
//                );
//                mediaPlayer.start();
//            }
//        });
//        // we need to refactor uor code so first we will implments the Vewi.onClickListener in the Main Activty class
//
        // this refers to the View.onClickListner

        redBTN.setOnClickListener(this);
        balckBTN.setOnClickListener(this);
        greenBTN.setOnClickListener(this);
        yellowBTN.setOnClickListener(this);
        purpelBTN.setOnClickListener(this);
        // navigate ti quiz
        Button toQuiz = findViewById(R.id.GoToQuizButton);
        toQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the Second Activity
                Intent intent = new Intent(unit_2.this, color_test.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        int clikedBtnClicked=v.getId();
        if(clikedBtnClicked==R.id.redBTN){
            playSound(R.raw.red);
            Toast.makeText(getApplicationContext(),"rouge",Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.blackBTN) {
            playSound(R.raw.black);
            Toast.makeText(getApplicationContext(),"noir",Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.greenBTN) {
            playSound(R.raw.green);
            Toast.makeText(getApplicationContext(),"vert",Toast.LENGTH_SHORT).show();

        } else if (clikedBtnClicked==R.id.purpelBTN) {
            playSound(R.raw.purple);
            Toast.makeText(getApplicationContext(),"violet",Toast.LENGTH_SHORT).show();

        }else  {
            playSound(R.raw.yellow);
            Toast.makeText(getApplicationContext(),"jaune",Toast.LENGTH_SHORT).show();



        }
    }
    public void playSound(int id){
        MediaPlayer mediaPlayer= MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();
    }

    public  void openSecond_Acc(){
        Intent i=new Intent(this, unit_3.class);
        startActivity(i);

    }
}