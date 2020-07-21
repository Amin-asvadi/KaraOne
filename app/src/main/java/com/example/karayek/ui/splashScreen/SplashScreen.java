package com.example.karayek.ui.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.karayek.MainActivity;
import com.example.karayek.R;
import com.example.karayek.ui.sahmList.SahamListActivity;

public class SplashScreen extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {
				// This method will be executed once the timer is over
				Intent i = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}, 5000); // ----Main Activity Start After 3 Sec.

	}
}