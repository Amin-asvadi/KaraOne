package com.khobre.karayek.ui.sahmList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SahamListInterFace {
    @GET("get_edalat_information")
    Call<List<SahamListModel>> getSahamList();

}
