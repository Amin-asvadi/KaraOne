package com.khobre.karayek.ui.splashScreen;

import com.khobre.karayek.ui.sahmList.SahamListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SplashInterface {
    public interface SahamListInterFace {
        @GET("update_saham_edalat_db.php")
        Call<List<SahamListModel>> getSahamList();

    }

}
