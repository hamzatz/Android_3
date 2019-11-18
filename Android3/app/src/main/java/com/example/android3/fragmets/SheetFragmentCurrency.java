package com.example.android3.fragmets;


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

import com.example.android3.R;
import com.example.android3.data.network.retrofitcurrency.RetrofitCurBuilder;
import com.example.android3.fragmets.adapter.CurrencyAdapter;
import com.example.android3.fragmets.currency.Rates;
import com.example.android3.fragmets.currency.Root;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android3.BuildConfig.ACCESS_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class SheetFragmentCurrency extends BottomSheetDialogFragment implements View.OnClickListener{

    private RecyclerView recyclerView;

    private CurrencyAdapter currencyAdapter;
    private ArrayList<Rates> ratesArrayList;
    private BottomSheetBehavior sheetBehavior;
    View view;

    public SheetFragmentCurrency() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_sheet_fragment_currency, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecycler();
        bottomSheetCur();
        showCurrency();
    }

    private void initRecycler() {
        ratesArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_view_cur);
        currencyAdapter = new CurrencyAdapter(ratesArrayList,getContext());
        recyclerView.setAdapter(currencyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void showCurrency(){


        RetrofitCurBuilder.getRetrofitServiceCur().getCurrency(ACCESS_KEY).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Log.e("ololo", response.toString());
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
    public void onClick(View v) {

    }
}
