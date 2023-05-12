package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DbHelperLogin extends SQLiteOpenHelper {


    public DbHelperLogin(@Nullable Context context) {
        super(context, "users_db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users_table (id integer primary key autoincrement, username text, password text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users_table");
        onCreate(db);
    }

    public long insertUser(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);

        long newRowId = db.insert("users_table", null, values);
        db.close();
        return newRowId;
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from users_table where id = " + id);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users_table", null);
        return cursor;
    }

    public boolean fetchUser(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("users_table", new String[]{"id"}, "username =? and password =?",
                new String[]{username, password}, null, null, null);

        int numRows = cursor.getCount();
        db.close();

        if (numRows > 0) {
            return true;
        } else {
            return false;
        }


    }
}
