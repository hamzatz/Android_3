package com.example.android3.data.network;

import com.example.android3.data.entity.weather.CurrentWeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET(ApiEndpoints.CURRENT_WEATHER)
    Call<CurrentWeatherEntity>getCurrentWeather(@Query("q")String city,@Query("appid")String appId, @Query("units") String metric);

}
