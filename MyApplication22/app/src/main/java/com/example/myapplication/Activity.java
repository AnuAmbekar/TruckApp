package com.example.myapplication;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Activity extends AppCompatActivity {

    DbHelper db;
    TextView textView10, textView11, textView12, textView13, textView14, textView15;
    List<String> reciever, date, time, location;
    List<String> goods, vehicle, length, weight, height, quantity;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        db = new DbHelper(this);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView6 = findViewById(R.id.textView6);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView7 = findViewById(R.id.textView7);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView8 = findViewById(R.id.textView8);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);


        String name = getIntent().getStringExtra("RECIEVER");
        String date = getIntent().getStringExtra("DATE");
        String time = getIntent().getStringExtra("TIME");
        String location = getIntent().getStringExtra("LOCATION");
        String goods = getIntent().getStringExtra("GOODS");
        String vehicle =  getIntent().getStringExtra("VEHICLE");
        String length = getIntent().getStringExtra("LENGTH");
        String weight = getIntent().getStringExtra("WEIGHT");
        String height = getIntent().getStringExtra("HEIGHT");
        String quantity = getIntent().getStringExtra("QUANTITY");


        textView6.setText(name);
        textView7.setText(date);
        textView8.setText(time);
        textView9.setText(location);
        textView10.setText(goods);
        textView11.setText(vehicle);
        textView12.setText(length);
        textView13.setText(weight);
        textView14.setText(height);
        textView15.setText(quantity);




        //String username = getIntent().getStringExtra("username");

    }
}
