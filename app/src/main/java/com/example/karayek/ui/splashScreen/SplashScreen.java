package com.example.karayek.ui.splashScreen;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.karayek.MainActivity;
import com.example.karayek.R;
import com.example.karayek.ui.sahmList.SahamListActivity;
import com.example.karayek.ui.sahmList.SahamListAdapter;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {
				// This method will be executed once the timer is over
				Intent i = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}, 2500); // ----Main Activity Start After 3 Sec.
		Retrofit retrofit = new Retrofit.Builder()
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
		});

	}
}