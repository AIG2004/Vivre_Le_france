package com.example.vivrelefrance;





import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*
 * numbers screen
 */

// we created a dicrictory called raw in res and putted in it the .mp3 files ,we can acces the files in it by id
// we implemted this interterface cuase we want to refactor our code
public class unit_1 extends AppCompatActivity implements View.OnClickListener{
    Button oneBTN,twoBTN,threeBTN,fourBTN,fiveBTN,sixBTN,sevenBTN,eightBTN,tenBTN,nineBTN;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1);

        oneBTN=findViewById(R.id.oneBTN);
        twoBTN=findViewById(R.id.twoBTN);
        threeBTN=findViewById(R.id.threeBTN);
        fourBTN=findViewById(R.id.fourBTN);
        fiveBTN=findViewById(R.id.fiveBTN);
        sixBTN=findViewById(R.id.sixBTN);
        sevenBTN=findViewById(R.id.sevenBTN);
        eightBTN=findViewById(R.id.eightBTN);
        nineBTN=findViewById(R.id.nineBTN);
        tenBTN=findViewById(R.id.tenBTN);
        // this refers to the View.onClickListner
        oneBTN.setOnClickListener(this);
        twoBTN.setOnClickListener(this);
        threeBTN.setOnClickListener(this);
        fourBTN.setOnClickListener(this);
        fiveBTN.setOnClickListener(this);
        sixBTN.setOnClickListener(this);
        sevenBTN.setOnClickListener(this);
        eightBTN.setOnClickListener(this);
        tenBTN.setOnClickListener(this);

        // navigate to quiz
        Button toQuiz = findViewById(R.id.GoToQuizButton);
        toQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the Second Activity
                Intent intent = new Intent(unit_1.this, number_test.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onClick(View v) {
        int clikedBtnClicked=v.getId();
        if(clikedBtnClicked==R.id.oneBTN){
            playSound(R.raw.one);
            Toast.makeText(getApplicationContext(),"Un", Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.twoBTN) {
            playSound(R.raw.two);

            Toast.makeText(getApplicationContext(),"deux", Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.threeBTN) {
            playSound(R.raw.three);

            Toast.makeText(getApplicationContext(),"trois", Toast.LENGTH_SHORT).show();
        } else if (clikedBtnClicked==R.id.fourBTN) {
            playSound(R.raw.four);

            Toast.makeText(getApplicationContext(),"quatre", Toast.LENGTH_SHORT).show();
        }else if(clikedBtnClicked==R.id.fiveBTN){
            playSound(R.raw.five);

            Toast.makeText(getApplicationContext(),"cinq", Toast.LENGTH_SHORT).show();
        }
        else if(clikedBtnClicked==R.id.sixBTN){
            playSound(R.raw.six);

            Toast.makeText(getApplicationContext(),"six", Toast.LENGTH_SHORT).show();
        }else if(clikedBtnClicked==R.id.sevenBTN){
            playSound(R.raw.seven);


            Toast.makeText(getApplicationContext(),"Sept", Toast.LENGTH_SHORT).show();
        }

        else if(clikedBtnClicked==R.id.eightBTN){
            playSound(R.raw.eight);
            Toast.makeText(getApplicationContext(),"huit", Toast.LENGTH_SHORT).show();

        }
        else if(clikedBtnClicked==R.id.nineBTN){
            playSound(R.raw.nine);
            Toast.makeText(getApplicationContext(),"neuf", Toast.LENGTH_SHORT).show();
        }else {
            playSound(R.raw.ten);
            Toast.makeText(getApplicationContext(),"dix", Toast.LENGTH_SHORT).show();
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
        Intent i=new Intent(this, unit_2.class);
        startActivity(i);

    }

}