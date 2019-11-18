package com.example.android3.fragmets;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3.R;
import com.example.android3.data.network.retrofitcurrency.RetrofitCurBuilder;
import com.example.android3.fragmets.currency.Root;
import com.example.android3.ui.base.BaseFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android3.BuildConfig.ACCESS_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends BaseFragment {




    public MapFragment() {

    }

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_map;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}





