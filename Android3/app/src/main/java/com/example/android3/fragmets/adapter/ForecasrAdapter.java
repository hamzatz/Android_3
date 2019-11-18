package com.example.android3.fragmets.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3.R;

import java.util.ArrayList;
import java.util.List;

public class ForecasrAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
    private List<com.example.android3.data.entity.forecast.List> data = new ArrayList<>();


    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_forecast_weather, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
         holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<com.example.android3.data.entity.forecast.List> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    public void clearItems() {
        this.data.clear();
        notifyDataSetChanged();
    }
}


