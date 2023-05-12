package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomepageRecyclerView extends RecyclerView.Adapter<HomepageRecyclerView.ViewHolder> {

    Context context;
    List<Trucks> truckUsers = new ArrayList<>();
    public HomepageRecyclerView(Context context, List<Trucks> truckUsers) {
        this.context = context;
        this.truckUsers = truckUsers;
    }
    @NonNull
    @Override
    public HomepageRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.activity_homepage_recycler_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomepageRecyclerView.ViewHolder holder, int position) {
        holder.textView.setText(truckUsers.get(position).getTitle());
        holder.textView2.setText(truckUsers.get(position).getVehicle());
        holder.textView3.setText(truckUsers.get(position).getService());
        holder.textView4.setText(truckUsers.get(position).getAvailable());
    }

    @Override
    public int getItemCount() {
        return truckUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2, textView3, textView4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
        }
    }
}