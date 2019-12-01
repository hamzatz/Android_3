package com.example.android3.ui.fragmets;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3.R;
import com.example.android3.data.entity.forecast.List;
import com.example.android3.data.entity.forecast.WeatherForecast;
import com.example.android3.data.network.retrofitweather.RetrofitBuilder;
import com.example.android3.ui.fragmets.adapter.ForecasrAdapter;
import com.example.android3.ui.base.BaseFragment;
import com.example.android3.ui.main.Listener;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android3.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends BaseFragment implements Listener {

    @BindView(R.id.gradu2)
            TextView txtDate;

    @BindView(R.id.recycler_view)
            RecyclerView recyclerView;

    ForecasrAdapter adapter;

    private  Listener listener;


    public ForecastFragment() {

    }


    @Override
    protected int getViewLayout() {
        return R.layout.fragment_forecast;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_forecast, container, false);
        showForecastWeather();
        initAdapter();

        return view;
    }


    public void showForecastWeather () {

        RetrofitBuilder.getRetrofitService().getWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<WeatherForecast>() {
                    @Override
                    public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                        if (response.body()!= null){
                            Toast.makeText(getContext(), "5 days forecast", Toast.LENGTH_LONG).show();

                            adapter.setItems(response.body().getList());
                            txtDate.setText(response.body().getList().get(0).getDtTxt());
                            Log.d("ololos", response.body().getList().get(0).getDtTxt());
                        }

                    }

                    @Override
                    public void onFailure(Call<WeatherForecast> call, Throwable t) {
                        Log.d("sdfsdsd", "asdasdsad");
                    }
                });
    }
    private void initAdapter(){
        adapter = new ForecasrAdapter(listener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(List list) {


    }
}
