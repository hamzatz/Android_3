package com.example.android3.ui.fragmets;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android3.R;
import com.example.android3.data.entity.forecast.WeatherForecast;
import com.example.android3.data.network.retrofitweather.RetrofitBuilder;
import com.example.android3.ui.fragmets.adapter.ForecasrAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.android3.BuildConfig.WEATHER_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class SheetFragment2 extends BottomSheetDialogFragment implements  View.OnClickListener{

    private BottomSheetBehavior btmsheet;
    ForecasrAdapter adapter;

    View view;

    private RecyclerView recyclerView;

    public SheetFragment2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sheet2, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        bottomSheet();
        initAdapter();
        initForecast();
    }

    private void initViews(View v){
        recyclerView = v.findViewById(R.id.recycler_view);
    }

    @Override
    public void onClick(View v) {

    }

    private void initForecast(){
        RetrofitBuilder.getRetrofitService().getWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<WeatherForecast>() {
                    @Override
                    public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                        if (response.body()!= null){
                            Toast.makeText(getContext(), "it is forecast", Toast.LENGTH_LONG).show();
                            adapter.setItems(response.body().getList());
                        }

                    }

                    @Override
                    public void onFailure(Call<WeatherForecast> call, Throwable t) {

                    }
                });
    }

    private void initAdapter(){
        adapter = new ForecasrAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void  bottomSheet(){



        View bottomSheep = view.findViewById(R.id.bottom_sheet);

        btmsheet = BottomSheetBehavior.from(bottomSheep);
        btmsheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
        btmsheet.setState(BottomSheetBehavior.STATE_EXPANDED);
        btmsheet.setState(BottomSheetBehavior.STATE_HIDDEN);
        btmsheet.setPeekHeight(500);
        btmsheet.setHideable(false);


        btmsheet.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        bottomSheep.setOnClickListener(v -> {
            if (btmsheet.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                btmsheet.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                btmsheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }

        });
    }
}
