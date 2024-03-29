package com.example.android3.ui.fragmets.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android3.ui.fragmets.MapFragment;
import com.example.android3.ui.fragmets.WeatherFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] childFragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

        childFragments = new Fragment[]{
                new WeatherFragment(),
                new MapFragment(),

        };
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new WeatherFragment();


            case 1:
                return new MapFragment();

        }
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Weather";
                break;

            case 1:
                title="Map";
        }
        return title;
    }
}
