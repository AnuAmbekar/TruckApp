package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Order extends AppCompatActivity {
    Button nextStep;
    EditText receiverEditText, pickupTimeEdit, pickupLocationEdit;
    ImageView imageView;
    CalendarView calendarView;
    String date;

    byte[] img;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        receiverEditText = findViewById(R.id.recieverEditText);
        pickupTimeEdit = findViewById(R.id.pickupTimeEdit);
        pickupLocationEdit = findViewById(R.id.pickupLocationEdit);
        calendarView = findViewById(R.id.calendarView);
        imageView = findViewById(R.id.imageView);

        nextStep = findViewById(R.id.nextStep2);
        String reciever = receiverEditText.getText().toString();
        String pickup = pickupTimeEdit.getText().toString();
        String location = pickupLocationEdit.getText().toString();




        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int init_month, int dayOfMonth) {
                int month = init_month + 1;
                date = dayOfMonth + "/" + month + "/" + year;
            }
        });

        nextStep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, Weights.class);
                intent.putExtra("reciever", receiverEditText.getText().toString());
                intent.putExtra("pickup", pickupTimeEdit.getText().toString());
                intent.putExtra("location", pickupLocationEdit.getText().toString());
                intent.putExtra("date", date);
                intent.putExtra("image", img);
                System.out.println(receiverEditText.getText().toString());
                System.out.println(pickupTimeEdit.getText().toString());
                System.out.println(pickupLocationEdit.getText().toString());
                System.out.println(img);


                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 100);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK) {
            if (requestCode==100) {
                Bitmap image = (Bitmap)(data.getExtras().get("data"));
                imageView.setImageBitmap(image);
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                img = byteArray.toByteArray();



            }
        }
    }
}