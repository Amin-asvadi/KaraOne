package com.example.karayek.ui.splashScreen;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
	ConstraintLayout splash_internet_connect;
	ImageView spalsh_internet_is_not;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();

		splash_internet_connect = findViewById(R.id.splash_cons);
		spalsh_internet_is_not = findViewById(R.id.img_internet_connection);



		ConnectivityManager manager = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

		if (null!=activeNetwork){
			if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){

				requestToServer();
				goToActivity();

			}
			if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
				requestToServer();
				goToActivity();
			}


		}else{
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
		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {
				// This method will be executed once the timer is over
				Intent i = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}, 2500); // ----Main Activity Start After 3 Sec.
	}

	private void requestToServer() {
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