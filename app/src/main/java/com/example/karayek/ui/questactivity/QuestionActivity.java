package com.example.karayek.ui.questactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.karayek.MainActivity;
import com.example.karayek.R;
import com.example.karayek.ui.splashScreen.SplashScreen;

public class QuestionActivity extends AppCompatActivity {
	WebView qestion_webView;
	Animation rotateAnimation;
	ImageView rotateImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		rotateImg = findViewById(R.id.img_rotae);
		rotateAnimation = AnimationUtils.loadAnimation(QuestionActivity.this,R.anim.rotate);
		rotateImg.setAnimation(rotateAnimation);

		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {

				rotateImg.setVisibility(View.GONE);
				qestion_webView.setVisibility(View.VISIBLE);
			}
		}, 7000); // ----Main Activity Start After 3 Sec.



		qestion_webView = findViewById(R.id.qestion_webView);
		qestion_webView.loadUrl("http://mashhadburse.ir/frequently-asked-questions/");
		WebSettings webSettings = qestion_webView.getSettings();
		webSettings.setJavaScriptEnabled(true);

	}

	@Override
	public void onBackPressed() {
		if (qestion_webView.canGoBack()){

			qestion_webView.goBack();
		}else{

			super.onBackPressed();
		}

	}
}