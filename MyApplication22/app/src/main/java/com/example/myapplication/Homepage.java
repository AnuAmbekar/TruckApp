package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Trucks> trucksList = new ArrayList<>();
    HomepageRecyclerView recyclerViewAdapter;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        button = findViewById(R.id.button3);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new HomepageRecyclerView(this, trucksList);

        trucksList.add(new Trucks("Fresh Delivery", "Truck", "Delivers furniture", "Everyday"));
        trucksList.add(new Trucks("Tough Service", "Van", "House-moving services", "Everyday"));
        trucksList.add(new Trucks("Mini-Truck Machine", "Mini-Truck", "Delivers hardware", "Everyday"));
        trucksList.add(new Trucks("Truck delivery", "Truck", "Delivers TVs", "Everyday"));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, Order.class));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                return true;
            case R.id.orders:
                startActivity(new Intent(Homepage.this, OrdersList.class));
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