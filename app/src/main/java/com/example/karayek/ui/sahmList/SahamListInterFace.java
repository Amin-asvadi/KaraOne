package com.example.karayek.ui.sahmList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SahamListInterFace {
    @GET("get_edalat_information.php")
    Call<List<SahamListModel>> getSahamList();

}
