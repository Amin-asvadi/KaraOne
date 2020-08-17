package com.khobre.karayek.ui.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

public static Retrofit retrofit =null;
public static Retrofit getApiClient(String uri){

    if (retrofit ==null){
        retrofit = new Retrofit.Builder().baseUrl(uri)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    return retrofit;
}
}
