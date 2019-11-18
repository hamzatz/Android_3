package com.example.android3.data.network.retrofitcurrency;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.android3.BuildConfig.CURRENCY_BASE_URL;


public class RetrofitCurBuilder {

    public static RetrofitServiceCur instance;
    private  static OkHttpClient client;

    public static  RetrofitServiceCur getRetrofitServiceCur(){

        if (instance == null){
            instance=buildRetrofitCur();
        }

        return instance;
    }

    private static  OkHttpClient getClient(){
        if (client == null) {
            client = okhttpBuilder();

        }

        return client;

    }

    private static OkHttpClient okhttpBuilder(){


      return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .build();
    }

    private static RetrofitServiceCur buildRetrofitCur(){
        return new Retrofit.Builder()
                .baseUrl(CURRENCY_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
                .create(RetrofitServiceCur.class);
    }


}
