package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class OrdersList extends AppCompatActivity implements ClickListener {

    RecyclerView recyclerView;
    DbHelper db;
    OrdersListRecycler recyclerViewAdapter;
    ArrayList<String> reciever, date, time, location, goods, vehicle, length, weight, height, quantity;
    ArrayList<byte[]> image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);
        db = new DbHelper(this);
        reciever = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();
        location = new ArrayList<>();
        goods = new ArrayList<>();
        vehicle = new ArrayList<>();
        length = new ArrayList<>();
        weight = new ArrayList<>();
        height = new ArrayList<>();
        quantity = new ArrayList<>();
        image = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new OrdersListRecycler(this, reciever, date, time, location, this); //this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData() {
        Cursor cursor = db.getData();

        if (cursor.getCount() == 0) {
            return;
        }

        else {
            while (cursor.moveToNext()) {
                image.add(cursor.getBlob(1));
                reciever.add(cursor.getString(2));
                date.add(cursor.getString(3));
                time.add(cursor.getString(4));
                location.add(cursor.getString(5));
                goods.add(cursor.getString(6));
                vehicle.add(cursor.getString(7));
                length.add(cursor.getString(8));
                weight.add(cursor.getString(9));
                height.add(cursor.getString(10));
                quantity.add(cursor.getString(11));
            }
        }
    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(OrdersList.this, Details.class);

        intent.putExtra("RECIEVER", reciever.get(position));
        intent.putExtra("DATE", date.get(position));
        intent.putExtra("TIME", time.get(position));
        intent.putExtra("LOCATION", location.get(position));
        intent.putExtra("GOODS", goods.get(position));
        intent.putExtra("VEHICLE", vehicle.get(position));
        intent.putExtra("LENGTH", length.get(position));
        intent.putExtra("WEIGHT", weight.get(position));
        intent.putExtra("HEIGHT", height.get(position));
        intent.putExtra("QUANTITY", quantity.get(position));
        intent.putExtra("image", image.get(position));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(OrdersList.this, Homepage.class));
                return true;
            case R.id.orders:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
}