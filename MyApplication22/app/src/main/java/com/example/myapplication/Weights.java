package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Weights extends AppCompatActivity {
    Button button;
    EditText goodsEdit, vehicleEdit, lengthEdit, weightEdit, heightEdit, quantityEdit;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights);
        button = findViewById(R.id.button);
        goodsEdit = findViewById(R.id.goodsEdit);
        vehicleEdit = findViewById(R.id.vehicleEdit);
        lengthEdit = findViewById(R.id.lengthEdit);
        weightEdit = findViewById(R.id.weightEdit);
        heightEdit = findViewById(R.id.heightEdit);
        quantityEdit = findViewById(R.id.quantityEdit);




        db = new DbHelper(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reciever = getIntent().getStringExtra("reciever");
                String pickup = getIntent().getStringExtra("pickup");
                String location = getIntent().getStringExtra("location");
                String date = getIntent().getStringExtra("date");
                byte[] images = getIntent().getByteArrayExtra("image");

                String goods = goodsEdit.getText().toString();
                String vehicle = vehicleEdit.getText().toString();
                String length = lengthEdit.getText().toString();
                String weight = weightEdit.getText().toString();
                String height = heightEdit.getText().toString();
                String quantity = quantityEdit.getText().toString();

                long insert = db.insertData(images, reciever, date, pickup, location, goods, vehicle, length, weight, height, quantity);

                if (insert > 0) {

                    Toast.makeText(Weights.this, "The insert has worked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Weights.this, OrdersList.class));
                }

                else {
                    Toast.makeText(Weights.this, "Didn't work", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}