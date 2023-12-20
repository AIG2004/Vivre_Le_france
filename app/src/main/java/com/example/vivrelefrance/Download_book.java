package com.example.vivrelefrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Download_book extends AppCompatActivity {
Button b1,b2,h;
final String url1="https://drive.google.com/u/0/uc?id=1XEZhfm-F5xVovhlImS1Jg0RZpIH-tCDa&export=download";
final String url2="https://drive.google.com/u/0/uc?id=1NjD656aiqiE6JQ_BtGmYyBOVOI0Uj0iV&export=download";
final String filename1="book1.pdf";
final String filename2="book2.pdf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_book);
        b1=findViewById(R.id.book1);
        b2=findViewById(R.id.book2);
        h=findViewById(R.id.home2);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Download_book.this,Home_page.class);
                startActivity(home);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartBook1(url1,filename1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartBook2(url2,filename2);
            }
        });
    }

    private void StartBook1(String url1, String filename1) {
        Intent intent = new Intent(this, Download.class);
        intent.putExtra("url", url1);
        intent.putExtra("fileName", filename1);
        startService(intent);
    }

    private void StartBook2(String url2, String filename2) {
        Intent intent = new Intent(this, Download.class);
        intent.putExtra("url", url2);
        intent.putExtra("fileName", filename2);
        startService(intent);
    }
}