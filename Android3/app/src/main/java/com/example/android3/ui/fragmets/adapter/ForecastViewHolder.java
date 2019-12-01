package com.example.android3.ui.fragmets.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android3.R;
import com.example.android3.data.entity.forecast.List;
import com.example.android3.ui.main.Listener;
import com.example.android3.utils.StringUtils;

public class ForecastViewHolder extends RecyclerView.ViewHolder{
   private ImageView sun;
   private   TextView gradus;
   private TextView gradus2;
   private   TextView gradus3;
   private Context context;
   private Listener listener;

    public ForecastViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        sun= itemView.findViewById(R.id.image_sun);
        gradus=itemView.findViewById(R.id.gradus);
        gradus2=itemView.findViewById(R.id.gradu2);
        gradus3=itemView.findViewById(R.id.gradus3);
        this.listener = listener;
    }

    @SuppressLint("StringFormatMatches")
    public void bind(List list){
        listener = new Listener() {
            @Override
            public void onItemClick(List list) {
//                Log.d("ololo", "onItemClick: ");

            }
        };

        Glide.with(itemView).load(StringUtils.getImageUrl(itemView.getContext(), list))
        .into(sun);
        gradus.setText( String.format(itemView.getResources().getString(R.string.celcium), list.getMain().getTemp()));
        gradus2.setText( String.format(itemView.getResources().getString(R.string.celcium), list.getMain().getTempMax()));
        gradus3.setText( String.format(itemView.getResources().getString(R.string.celcium), list.getMain().getTempMin()));
        listener.onItemClick(list);

    }
}
