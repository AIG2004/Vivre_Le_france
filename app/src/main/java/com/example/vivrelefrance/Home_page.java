package com.example.vivrelefrance;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Home_page extends AppCompatActivity {
    Button unit1,unit2,unit3,unit4,online;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Air_Plane Air=new Air_Plane();
        IntentFilter i =new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        internet_status is=new internet_status();
        registerInternetReceiver(is);
        registerReceiver(Air,i);
        unit1=findViewById(R.id.unit1);
        unit2=findViewById(R.id.unit2);
        unit3=findViewById(R.id.unit3);
        unit4=findViewById(R.id.unit4);
        online=findViewById(R.id.online_mode);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!is.isNetworkAvailable(Home_page.this)) {
                    Toast.makeText(Home_page.this, "Airplane mode on, offline mode only", Toast.LENGTH_LONG).show();
                    return;
                } else if (Air.isAirplaneModeEnabled) {
                    Toast.makeText(Home_page.this, "Airplane mode on, offline mode only", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent online_page = new Intent(Home_page.this, online_mode.class);
                startActivity(online_page);
            }
        });


        //navigations
        unit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to unit 1 numbers
                Intent intent = new Intent(Home_page.this, unit_1.class);
                startActivity(intent);
            }
        });

        unit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to unit 2 colors
                Intent intent = new Intent(Home_page.this, unit_2.class);
                startActivity(intent);
            }
        });

        unit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to unit 3 family
                Intent intent = new Intent(Home_page.this, unit_3.class);
                startActivity(intent);
            }
        });

        unit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(Home_page.this,unit_4.class);
                startActivity(i4);
            }
        });

    }
    private void registerInternetReceiver(internet_status is) {
        IntentFilter isf = new IntentFilter();
        isf.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(is, isf);
    }
}