package com.example.android3.ui.fragmets;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android3.R;
import com.example.android3.data.network.retrofitcurrency.RetrofitCurBuilder;
import com.example.android3.ui.fragmets.adapter.CurrencyAdapter;
import com.example.android3.ui.fragmets.currency.Rates;
import com.example.android3.ui.fragmets.currency.Root;
import com.example.android3.ui.main.Listener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android3.BuildConfig.ACCESS_KEY;
import static com.example.android3.BuildConfig.MAP_KEY;
import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment{


    private BottomSheetBehavior sheetBehavior;
    View view;
    private MapView mapView;
    Listener listener;
    private EditText CurSom;
    private Button convertBtn;
    private TextView resultTxt;
    private Spinner spinner;


    public MapFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Listener) {
            listener = (Listener) context;
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Mapbox.getInstance(getContext(), MAP_KEY);
        Mapbox.setAccessToken(MAP_KEY);
        view = inflater.inflate(R.layout.fragment_map, container, false);
        CurSom = view.findViewById(R.id.editText4);
        convertBtn = view.findViewById(R.id.button_convert);
        resultTxt = view.findViewById(R.id.text_result);
        spinner = view.findViewById(R.id.planets_spinner);



        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {

                    // Map is set up and the style has loaded. Now you can add data or make other map adjustments

                });

            }
        });




        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottomSheetCur();
        showCurrency();
        mapView.onCreate(savedInstanceState);
    }


    public void showCurrency(){

        RetrofitCurBuilder.getRetrofitServiceCur().getCurrency( ACCESS_KEY,"USD").enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Log.e("ololo", response.toString());
                convertBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String spinnerValue = spinner.getSelectedItem().toString();
                        response.body().getBase();
                        double rates = response.body().getRates().getEUR();
                        if (spinnerValue.equals("RUB")){
                            rates = response.body().getRates().getRUB();
                        } else if (spinnerValue.equals("USD")){
                            rates = response.body().getRates().getUSD();
                        }else if (spinnerValue.equals("KGS")){
                            rates = response.body().getRates().getKGS();
                        }
                        String value = CurSom.getText().toString();
                        int convertedValue = Integer.parseInt(value);
                        String converted = String.valueOf(convertedValue * rates);
                        resultTxt.setText(converted);
                    }
                });
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }




    private void  bottomSheetCur(){



        View bottomSheepCur = view.findViewById(R.id.bottom_sheet_cur);

        sheetBehavior = BottomSheetBehavior.from(bottomSheepCur);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        sheetBehavior.setPeekHeight(500);
        sheetBehavior.setHideable(false);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
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

        bottomSheepCur.setOnClickListener(v -> {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }

        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


}





