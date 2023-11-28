package com.example.vivrelefrance;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class sqlite extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;
    sqlite(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE users ( name VARCHAR(50)," +
                "email VARCHAR(50)," +
                "username VARCHAR(50) PRIMARY KEY," +
                "password VARCHAR(50))";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void adduser(String name,String email,String username,String password){
        SQLiteDatabase db=this.getWritableDatabase(); //to write in db
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("username",username);
        cv.put("password",password);
        long result =db.insert("users",null,cv);
        if(result==-1){
            Toast.makeText(context, "FAILED", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "SUCCESFULLY ADDED", Toast.LENGTH_SHORT).show();

        }
    }
    public boolean validate(String user,String pass){
            SQLiteDatabase db = this.getReadableDatabase();
            String validation_query = "SELECT * FROM users WHERE username='" + user + "' AND password='" + pass + "'";
            Cursor cursor = null;

            try {
                cursor = db.rawQuery(validation_query, null);
                return cursor.getCount() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }

            return false;
        }}

