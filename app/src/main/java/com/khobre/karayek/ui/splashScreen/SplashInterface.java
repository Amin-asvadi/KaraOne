package com.khobre.karayek.ui.splashScreen;

import com.khobre.karayek.ui.model.Price;
import com.khobre.karayek.ui.sahmList.SahamListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SplashInterface {

        @GET("saham_edalat_price1/")
        Call<List<Price>> getPrice();


}
