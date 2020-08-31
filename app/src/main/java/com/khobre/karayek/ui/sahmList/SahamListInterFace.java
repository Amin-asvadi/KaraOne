package com.khobre.karayek.ui.sahmList;

import androidx.cardview.widget.CardView;

import com.khobre.karayek.ui.model.Price;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SahamListInterFace {
    @GET("get_edalat_information")
    Call<List<SahamListModel>> getSahamList();


    @GET("saham_edalat_price/")
    Call<List<Price>> getPrice();




}
