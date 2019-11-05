package com.example.android3.ui.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.android3.R;
import com.example.android3.data.entity.OnBoardEntity;

import java.util.ArrayList;

public class OnBoardAdapter extends PagerAdapter {

    private TextView textView;
    private ArrayList<OnBoardEntity>resourse;


    public OnBoardAdapter(ArrayList<OnBoardEntity> resourse) {
        this.resourse =resourse;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_view_pager, null);
        ImageView imageView = view.findViewById(R.id.image_view);
        textView= view.findViewById(R.id.text_view);
        imageView.setImageDrawable(container.getContext().getResources().getDrawable(resourse.get(position).getImg()));
        textView.setText(resourse.get(position).getTitle());
        container.addView(view);
        return view;
    }




    @Override
    public int getCount() {
        return resourse.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object==view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {

        container.removeView((View) view);

    }
}
