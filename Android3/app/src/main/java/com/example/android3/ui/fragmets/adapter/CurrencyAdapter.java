package com.example.android3.ui.fragmets.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3.R;
import com.example.android3.ui.fragmets.currency.Rates;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    ArrayList<Rates> ratesArrayList;

    Context context;


    public CurrencyAdapter(ArrayList<Rates> ratesArrayList, Context context) {
        this.ratesArrayList = ratesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_map,parent,false);

        return new CurrencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {
    holder.textView.setText(ratesArrayList.get(position).getEUR());

    }

    @Override
    public int getItemCount() {
        return ratesArrayList.size();
    }

    public class CurrencyViewHolder extends RecyclerView.ViewHolder{
            TextView textView, currency,value,result;


        public CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.euro);
            textView= itemView.findViewById(R.id.text_currency);
            textView = itemView.findViewById(R.id.text_value);
            textView = itemView.findViewById(R.id.text_result);

        }
    }
}
