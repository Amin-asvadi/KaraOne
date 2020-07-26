package com.example.karayek.ui.sahmList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SahamListInterFace {
    @GET("kara1_real_time_trades.php")
    Call<List<SahamListModel>> getSahamList();

}
