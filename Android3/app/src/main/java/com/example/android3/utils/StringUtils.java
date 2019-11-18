package com.example.android3.utils;

import android.content.Context;

import com.example.android3.R;
import com.example.android3.data.entity.forecast.List;

public class StringUtils {

    public static String getImageUrl(Context context, List icon){
        return  String.format(context.getResources().getString(R.string.image_url), icon.getWeather().get(0).getIcon());
    }
}
