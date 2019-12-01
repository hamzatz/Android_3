package com.example.android3.ui.fragmets;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3.R;
import com.example.android3.data.entity.forecast.WeatherForecast;
import com.example.android3.data.entity.weather.CurrentWeatherEntity;
import com.example.android3.data.network.retrofitweather.RetrofitBuilder;
import com.example.android3.ui.fragmets.adapter.ForecasrAdapter;
import com.example.android3.ui.base.BaseFragment;
import com.example.android3.utils.DateTimeHelper;

import java.util.ArrayList;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android3.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends BaseFragment {




   private ForecasrAdapter adapter;
   private ArrayList<CurrentWeatherEntity> currentWeatherEntityArrayList;

   @BindView(R.id.address)
   TextView address;
   @BindView(R.id.updated_at)
   TextView updated;
   @BindView(R.id.status)
   TextView status;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.temp_min)
    TextView tempmin;
    @BindView(R.id.temp_max)
    TextView tempmax;
    @BindView(R.id.sunrise)
    TextView  sunrise;
    @BindView(R.id.sunset)
    TextView sunset;
    @BindView(R.id.wind)
    TextView wind;
    @BindView(R.id.pressure)
    TextView pressure;
    @BindView(R.id.humidity)
    TextView humidity;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public WeatherFragment() {

    }


    @Override
    protected int getViewLayout() {
        return R.layout.fragment_weather;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViewsWeather(view);
        initAdapter();
        showCurrentWeather();
        initForecast();
    }

    private void showCurrentWeather() {

        RetrofitBuilder.getRetrofitService().getCurrentWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        Log.d("ololo", response.toString());
                        CurrentWeatherEntity data = response.body();

                        pressure.setText(data.getMain().getPressure());
                        temp.setText(data.getMain().getTemp());
                        tempmax.setText(data.getMain().getTemp_max());
                        tempmin.setText(data.getMain().getTemp_min());
                        humidity.setText(data.getMain().getHumidity());
                        wind.setText(data.getWind().getSpeed());
                        updated.setText(DateTimeHelper.getCurrentDateTime());
                        address.setText(data.getName());
                        status.setText(data.getWeather().get(0).getDescription());
                        sunrise.setText(DateTimeHelper.parseDateToTime(data.getSys().getSunrise()));
                        sunset.setText(DateTimeHelper.parseDateToTime(data.getSys().getSunset()));


                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {
                        Log.d("ololo", t.getMessage());

                    }
                });

    }

    private void initForecast(){
      RetrofitBuilder.getRetrofitService().getWeather("Bishkek", WEATHER_KEY, "metric")
         .enqueue(new Callback<WeatherForecast>() {
                  @Override
                    public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                        if (response.body()!= null){
                           Toast.makeText(getContext(), "5 days forecast", Toast.LENGTH_LONG).show();
                           adapter.setItems(response.body().getList());

                       }

                   }

                   @Override
                   public void onFailure(Call<WeatherForecast> call, Throwable t) {
          Log.d("sdfsdsd", "asdasdsad");                   }
              });
    }

   private void initAdapter(){
        adapter = new ForecasrAdapter();
       recyclerView.setAdapter(adapter);
   }

public  void  initViewsWeather(View view1){


}
    }
