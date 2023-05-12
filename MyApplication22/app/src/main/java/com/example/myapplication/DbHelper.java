package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "user_db.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user_table (id integer primary key autoincrement, image blob, name text, date text, pickup text, location text, goods text, vehicle text, length text, weight text, weight_name text, quantity text)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user_table", null);
        onCreate(db);
    }

    public long insertData(byte[] image, String name, String date, String pickup, String location, String goods, String vehicle,
                           String length, String weight, String weight_name, String quantity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("image", image);
        values.put("name", name);
        values.put("date", date);
        values.put("pickup", pickup);
        values.put("location", location);
        values.put("goods", goods);
        values.put("vehicle", vehicle);
        values.put("length", length);
        values.put("weight", weight);
        values.put("weight_name", weight_name);
        values.put("quantity", quantity);


        long rowIdInsert = db.insert("user_table", null, values);
        db.close();
        return rowIdInsert;

    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public void deleteUsers(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from user_table where id = " + id);
    }
}
