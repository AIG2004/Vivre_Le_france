package com.example.vivrelefrance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Sign_up extends AppCompatActivity {
CheckBox c2;
EditText name;
    EditText email;
    EditText username;
    EditText pass2;
    EditText confirmpass;
    Button Sign_up;

Button Sign2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username2);
        email = findViewById(R.id.email);
        pass2 = findViewById(R.id.password2);
        confirmpass = findViewById(R.id.confirmpass);
        c2 = findViewById(R.id.cb2);
        Sign_up = findViewById(R.id.sign2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c2.isChecked()) {
                    // Show password
                    pass2.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });
        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlite db = new sqlite(com.example.vivrelefrance.Sign_up.this);
                String pass1=pass2.getText().toString();
                String passs2=confirmpass.getText().toString();
                if (pass1.equals(passs2)) {
                    db.adduser(name.getText().toString().trim(), email.getText().toString().trim(), username.getText().toString().trim(), pass2.getText().toString().trim());
                    starthome();
                } else {
                    Toast.makeText(Sign_up.this, "passwords don't match", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void starthome() {
        Intent tohome=new Intent(this, Home_page.class);
        startActivity(tohome);
    }
}

