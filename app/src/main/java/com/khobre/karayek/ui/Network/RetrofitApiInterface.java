package com.khobre.karayek.ui.Network;


import com.khobre.karayek.ui.model.PaymentModel;
import com.khobre.karayek.ui.model.Users;

import java.net.ResponseCache;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitApiInterface {

/*
	@GET("v1/book/home")
	Observable<Response<Ser_Book_Main>> Get_Book_HomePage_Data(
            @Query("device_os") int device_os,
            @Query("version") int version
    );

	@GET("v1/book/291")
	Observable<Response<Ser_Book_Main>> Get_Url(
            @Query("id") int id
    );*/


    @POST("add_buyer")
    Call<ResponseBody> setData(@Body Users info);
}