package com.example.android3.fragmets;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3.R;
import com.example.android3.data.entity.weather.CurrentWeatherEntity;
import com.example.android3.data.network.RetrofitBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android3.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

   private TextView  address, updated, status,
            temp, tempmin, tempmax, sunrise,
            sunset, wind, pressure, humidity;


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);


        address =view.findViewById(R.id.address);
        updated = view.findViewById(R.id.updated_at);
        status = view.findViewById(R.id.status);
        temp = view.findViewById(R.id.temp);
        tempmin = view.findViewById(R.id.temp_min);
        tempmax = view.findViewById(R.id.temp_max);
        sunrise = view.findViewById(R.id.sunrise);
        sunset = view.findViewById(R.id.sunset);
        wind = view.findViewById(R.id.wind);
        pressure = view.findViewById(R.id.pressure);
        humidity = view.findViewById(R.id.humidity);

        showCurrentWeather();
        return view;
    }

    public void showCurrentWeather() {

        RetrofitBuilder.getRetrofitService().getCurrentWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        Log.d("ololo", "weather");
                        CurrentWeatherEntity data = response.body();

                        pressure.setText(data.getMain().getPressure());
                        temp.setText(data.getMain().getTemp());
                        tempmax.setText(data.getMain().getTemp_max());
                        tempmin.setText(data.getMain().getTemp_min());
                        humidity.setText(data.getMain().getHumidity());
                        wind.setText(data.getWind().getSpeed());
                        updated.setText(getCurrentTime());
                        address.setText(data.getName());
                        status.setText(data.getWeather().get(0).getDescription());
                        sunrise.setText(data.getSys().getSunrise());
                        sunset.setText(data.getSys().getSunset());




                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {
                        Log.d("ololo", "weather");

                    }
                });

    }
    public static String getCurrentTime() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    }
