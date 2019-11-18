package com.example.android3.data.network.retrofitcurrency;

import com.example.android3.data.entity.forecast.WeatherForecast;
import com.example.android3.data.entity.weather.CurrentWeatherEntity;
import com.example.android3.data.network.ApiEndpoints;
import com.example.android3.fragmets.currency.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServiceCur {

      @GET(ApiEndpoints.CURRENCY)

    Call<Root>getCurrency(
              @Query("access_key") String access);

}
