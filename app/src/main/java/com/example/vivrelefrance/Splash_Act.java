package com.example.vivrelefrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Act.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    public static class sqlite extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "vivre.db";
        private static final int DATABASE_VERSION = 1;
        private Context context;

        public sqlite( Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableQuery = "CREATE TABLE users ( name VARCHAR(50),  mail VARCHAR(50), username VARCHAR(50), password VARCHAR(50))";
            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
        public void adduser(String n,String em,String us,String pass){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv= new ContentValues();
            cv.put("name",n);
            cv.put("mail",em);
            cv.put("username",us);
            cv.put("password",pass);
            long result=db.insert("users",null,cv);
            if(result==-1){
                Toast.makeText(context,"FAILED", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,"SUCCES", Toast.LENGTH_SHORT).show();
            }

        }
    }
}