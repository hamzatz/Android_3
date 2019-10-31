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

public class OnBoardAdapter extends PagerAdapter {

    private TextView textView;

    public OnBoardAdapter() {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        context=container.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_pager, null);
        ImageView imageView = view.findViewById(R.id.image_view);
        textView=view.findViewById(R.id.text_view);
        switch (position) {
            case 0:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.step));
                textView.setText("Here you are may learn!");
                break;
            case 1:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.update));
                textView.setText("Here you are may update!");
                break;
            case 2:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.delete));
                textView.setText("Here you are may delete!");
                break;
            case 3:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.thanks));
                textView.setText("Thanks that you are with us!");
                break;
            default:
                imageView.setImageDrawable(context.getResources().getDrawable((position)));
        }
        container.addView(view);

        return view;
    }

    private Context context;


    @Override
    public int getCount() {
        return 4;
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
