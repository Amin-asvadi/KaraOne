package com.khobre.karayek.ui.questactivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.khobre.karayek.R;
import com.github.ybq.android.spinkit.SpinKitView;

public class QuestionActivity extends AppCompatActivity {
	WebView qestion_webView;
ImageView img_back;
	SpinKitView rotateImg;
			TextView inprogress,disable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		rotateImg = findViewById(R.id.img_rotae);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		img_back = findViewById(R.id.img_back_quest);
		inprogress = findViewById(R.id.txt_inprogress);
		disable = findViewById(R.id.vpn_queastion_txt_disable);
	/*	img_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});*/

		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {

				rotateImg.setVisibility(View.GONE);
				qestion_webView.setVisibility(View.VISIBLE);
				inprogress.setVisibility(View.GONE);
				disable.setVisibility(View.GONE);
			}
		}, 7000); // ----Main Activity Start After 3 Sec.



		qestion_webView = findViewById(R.id.qestion_webView);
		qestion_webView.clearCache(true);
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