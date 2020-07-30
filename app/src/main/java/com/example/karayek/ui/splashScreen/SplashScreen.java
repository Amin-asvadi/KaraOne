package com.example.karayek.ui.splashScreen;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.karayek.MainActivity;
import com.example.karayek.R;
import com.example.karayek.ui.ClsSharedPreference;
import com.example.karayek.ui.databse.DbSql;
import com.example.karayek.ui.sahmList.SahamListInterFace;
import com.example.karayek.ui.sahmList.SahamListModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashScreen extends AppCompatActivity {
    ConstraintLayout splash_internet_connect;
    ImageView spalsh_internet_is_not;
    Context context = this;
    private DbSql dbSQL = new DbSql(context);
    SahamListModel sahamListModel;
    ClsSharedPreference prefManager;
    ArrayList<SahamListModel> sahamListItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        splash_internet_connect = findViewById(R.id.splash_cons);
        spalsh_internet_is_not = findViewById(R.id.img_internet_connection);


        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {

                requestToServer();


            }
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                requestToServer();

            }


        } else {
            Toast.makeText(this, "checkInternetConnection", Toast.LENGTH_SHORT).show();
            splash_internet_connect.setVisibility(View.GONE);
            spalsh_internet_is_not.setVisibility(View.VISIBLE);
            spalsh_internet_is_not.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(getIntent());
                }
            });
        }


    }

    private void goToActivity() {

        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);
        finish();

    }

    private void requestToServer() {
        prefManager = new ClsSharedPreference(this);
		/*Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://mashhadburse.ir/kara1/client/v1/api/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		SahamListInterFace GroupService = retrofit.create(SahamListInterFace.class);
		Call<List<SahamListModel>> call = GroupService.getSahamList();

		call.enqueue(new Callback<List<SahamListModel>>() {
			@Override
			public void onResponse(Call<List<SahamListModel>> call, Response<List<SahamListModel>> response) {

				if (response.isSuccessful()){

					Toast.makeText(SplashScreen.this, "بروزرسانی انجام شد", Toast.LENGTH_SHORT).show();
				}else {
					Log.e("ERROR",String.valueOf(response.code()));
					Toast.makeText(SplashScreen.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();

				}
			}

			@Override
			public void onFailure(Call<List<SahamListModel>> call, Throwable t) {
				Toast.makeText(SplashScreen.this, t.getMessage(), Toast.LENGTH_SHORT).show();

			}
		});*/


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mashhadburse.ir/kara1/client/v1/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SahamListInterFace GroupService = retrofit.create(SahamListInterFace.class);
        Call<List<SahamListModel>> call = GroupService.getSahamList();

        call.enqueue(new Callback<List<SahamListModel>>() {
            @Override
            public void onResponse(Call<List<SahamListModel>> call, Response<List<SahamListModel>> response) {
                sahamListModel = new SahamListModel();
                if (response.isSuccessful()) {
                    prefManager = new ClsSharedPreference(SplashScreen.this);
                    List<SahamListModel> saham_Live = response.body();
                    sahamListItems = (ArrayList<SahamListModel>) saham_Live;
                    int sum = 0;
                    for (int i = 0; i < saham_Live.size(); i++) {
                        sum += (Integer.valueOf(saham_Live.get(i).getCount()) * Integer.valueOf(saham_Live.get(i).getLivePrice()));


                    }
                    sahamListModel.setSum_price(String.valueOf(sum));
                    if (prefManager.isFirstTimeLaunch()) {
                        prefManager.setFirstTimeLaunch(false);
                        for (int j = 0; j < saham_Live.size(); j++) {
                            sahamListModel.setSum_price(String.valueOf(sum));
                            int stockValue = (Integer.valueOf(saham_Live.get(j).getCount()) * Integer.valueOf(saham_Live.get(j).getLivePrice()));

                            dbSQL.InsertDataSahamList(new SahamListModel(
                                    saham_Live.get(j).getGroup(), saham_Live.get(j).getTitle()
                                    , saham_Live.get(j).getCount(), saham_Live.get(j).getLivePrice()
                                    , String.valueOf(stockValue), String.valueOf(sum)));
                        }
                        for (int j = 0; j < saham_Live.size(); j++) {
                            //sahamListModel.setSum_price(String.valueOf(sum));
                            int multySum = (sum * 2);
                            int stockValue = (Integer.valueOf(saham_Live.get(j).getCount()) * Integer.valueOf(saham_Live.get(j).getLivePrice()));
                            int multystock = (stockValue * 2);
                            int multyCount = (Integer.valueOf(saham_Live.get(j).getCount()) * 2);
                            dbSQL.InsertDataSahamList_ONE(new SahamListModel(
                                    saham_Live.get(j).getGroup(), saham_Live.get(j).getTitle()
                                    , String.valueOf(multyCount), saham_Live.get(j).getLivePrice()
                                    , String.valueOf(multystock), String.valueOf(multySum)));
                            Toast.makeText(SplashScreen.this, "insert", Toast.LENGTH_SHORT).show();


                        }
                    } else {

                        for (int j = 0; j < saham_Live.size(); j++) {
                            //sahamListModel.setSum_price(String.valueOf(sum));
                            int multySum = (sum * 2);
                            int stockValue = (Integer.valueOf(saham_Live.get(j).getCount()) * Integer.valueOf(saham_Live.get(j).getLivePrice()));
                            int multystock = (stockValue * 2);
                            int multyCount = (Integer.valueOf(saham_Live.get(j).getCount()) * 2);
                            dbSQL.Update_One(new SahamListModel(
                                    saham_Live.get(j).getGroup(), saham_Live.get(j).getTitle()
                                    , String.valueOf(multyCount), saham_Live.get(j).getLivePrice()
                                    , String.valueOf(multystock), String.valueOf(multySum)), Integer.valueOf(j + 1));
                            Toast.makeText(SplashScreen.this, "updated", Toast.LENGTH_SHORT).show();
                        }
                        for (int i = 0; i < saham_Live.size(); i++) {
                            sahamListModel.setSum_price(String.valueOf(sum));
                            int stockValue = (Integer.valueOf(saham_Live.get(i).getCount()) * Integer.valueOf(saham_Live.get(i).getLivePrice()));

                            dbSQL.Update(new SahamListModel(
                                    saham_Live.get(i).getGroup(), saham_Live.get(i).getTitle()
                                    , saham_Live.get(i).getCount(), saham_Live.get(i).getLivePrice()
                                    , String.valueOf(stockValue), String.valueOf(sum)), i);
                            Toast.makeText(SplashScreen.this, "updated", Toast.LENGTH_SHORT).show();
                        }

                        Toast.makeText(SplashScreen.this, "EXIST", Toast.LENGTH_SHORT).show();

                    }
                    goToActivity();


                } else {
                    Log.e("ERROR", String.valueOf(response.code()));
                    Toast.makeText(SplashScreen.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<SahamListModel>> call, Throwable t) {
                Toast.makeText(SplashScreen.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}