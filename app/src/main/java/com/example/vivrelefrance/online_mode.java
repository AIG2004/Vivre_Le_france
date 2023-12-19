package com.example.vivrelefrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class online_mode extends AppCompatActivity {
Button search,homeB;
EditText Search_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_mode);
        search=findViewById(R.id.searchbutton);
        Search_box=findViewById(R.id.search);
        homeB=findViewById(R.id.home);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=Search_box.getText().toString();
                String url="https://www.collinsdictionary.com/dictionary/french-english/"+text;
                Intent online_search= new Intent (Intent.ACTION_VIEW, Uri.parse(url));
                online_search.setPackage("com.android.google");
                startActivity(online_search);
            }
        });
        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home= new Intent(online_mode.this, Home_page.class);
                startActivity(home);
            }
        });
    }
}