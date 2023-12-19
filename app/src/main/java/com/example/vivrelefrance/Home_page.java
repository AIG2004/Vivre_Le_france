package com.example.vivrelefrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Home_page extends AppCompatActivity {
Button unit1,unit2,unit3,unit4,online;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Air_Plane Air=new Air_Plane();
        IntentFilter i =new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(Air,i);
        unit1=findViewById(R.id.unit1);
        unit2=findViewById(R.id.unit2);
        unit3=findViewById(R.id.unit3);
        unit4=findViewById(R.id.unit4);
        online=findViewById(R.id.online_mode);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent online_page=new Intent(Home_page.this, online_mode.class);
                startActivity(online_page);
            }
        });

    }

}