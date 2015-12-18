package com.tomtom.workshop.workshopapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Copyright (C) TomTom International B.V., 2015
 * All rights reserved.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CarViewHolder>{

    List<Car> cars;

    public RecyclerViewAdapter(List<Car> list){
        this.cars = list;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        CarViewHolder cvh = new CarViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CarViewHolder carViewHolder, int position) {
        carViewHolder.icon.setImageResource(cars.get(position).iconId);
        carViewHolder.title.setText(cars.get(position).title);
        carViewHolder.subtitle.setText(cars.get(position).subtitle);
    }


    @Override
    public int getItemCount() {
        return cars.size();
    }

//    @Override
//    public int getItemViewType (int position) {
//        return TYPE;
//    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cv;
        private TextView title;
        private TextView subtitle;
        private ImageView icon;

        public CarViewHolder(View itemView){
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.cv);
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            icon = (ImageView) itemView.findViewById(R.id.icon);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), title.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }




}
