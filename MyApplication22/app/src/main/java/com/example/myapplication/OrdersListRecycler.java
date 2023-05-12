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

public class OrdersListRecycler extends RecyclerView.Adapter<OrdersListRecycler.ViewHolder> implements ClickListener{

    private final OrdersList ordersList;
    private Context context;
    private ArrayList textView9, textView8, textView6, textView7;

    public OrdersListRecycler(Context context, ArrayList textView9, ArrayList textView8, ArrayList textView6, ArrayList textView7,
                              OrdersList ordersList) {
        this.context = context;
        this.textView9 = textView9;
        this.textView8 = textView8;
        this.textView6 = textView6;
        this.textView7 = textView7;
        this.ordersList = ordersList;
    }

    @NonNull
    @Override
    public OrdersListRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.activity_orders_list_recycler, parent, false);
        return new ViewHolder(itemView, ordersList);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersListRecycler.ViewHolder holder, int position) {
        holder.textView9.setText(String.valueOf(textView9.get(position)));
        holder.textView8.setText(String.valueOf(textView8.get(position)));
        holder.textView6.setText(String.valueOf(textView6.get(position)));
        holder.textView7.setText(String.valueOf(textView7.get(position)));
    }

    @Override
    public int getItemCount() {
        return textView9.size();
    }

    @Override
    public void onClickListener(int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView9, textView8, textView6, textView7;
        public ViewHolder(@NonNull View itemView, OrdersList ordersList) {
            super(itemView);
            textView9 = itemView.findViewById(R.id.textView9);
            textView8 = itemView.findViewById(R.id.textView8);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ordersList != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            ordersList.onClickListener(position);
                        }
                    }
                }
            });

        }
    }
}