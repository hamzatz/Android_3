package com.example.android3.data.network.retrofitcurrency;

import com.example.android3.data.network.ApiEndpoints;
import com.example.android3.ui.fragmets.currency.Root;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitServiceCur {

      @GET(ApiEndpoints.CURRENCY)

    Call<Root>getCurrency(

              @Query("access_key") String access


    );


}
