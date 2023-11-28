package com.example.vivrelefrance;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.text.method.PasswordTransformationMethod;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
Button login;
Button Sign1;
CheckBox c1;
EditText user_text;
EditText pass_text;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1=findViewById(R.id.cb);
        login=findViewById(R.id.login);
        Sign1=findViewById(R.id.sign);
        user_text=findViewById(R.id.username);
        pass_text=findViewById(R.id.password);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()) {
                    // Show password
                    pass_text.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });
        Sign1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to_sign_up();
            }
        });
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //logic to check credentials
        sqlite db = new sqlite(MainActivity.this);
        String username = user_text.getText().toString();
        String password = pass_text.getText().toString();
        if (db.validate(username, password)) {
            Toast.makeText(MainActivity.this, "Welcome Back:"+username, Toast.LENGTH_SHORT).show();
            start_home();
        } else {
            Toast.makeText(MainActivity.this, "incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }
});
    }

    private void to_sign_up() {
        Intent to_sign_up=new Intent(this, Sign_up.class);
        startActivity(to_sign_up);
    }

    private void start_home() {
        Intent tohome=new Intent(this, Home_page.class);
        startActivity(tohome);
    }
    }



