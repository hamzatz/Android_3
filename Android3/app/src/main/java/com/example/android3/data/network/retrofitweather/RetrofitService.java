package com.example.android3.data.network.retrofitweather;

import com.example.android3.data.entity.forecast.WeatherForecast;
import com.example.android3.data.entity.weather.CurrentWeatherEntity;
import com.example.android3.data.network.ApiEndpoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

       @GET(ApiEndpoints.CURRENT_WEATHER)
    Call<CurrentWeatherEntity>getCurrentWeather(@Query("q")String city,
                                                @Query("appid")String appId,
                                                @Query("units") String metric);


      @GET(ApiEndpoints.FORECAST_WEATHER)
    Call<WeatherForecast>getWeather(@Query("q") String city,
                                    @Query("appid") String appId,
                                    @Query("units")String metric);

}
