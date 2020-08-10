package com.khobre.karayek.ui.inquirySahamActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.khobre.karayek.R;
import com.github.ybq.android.spinkit.SpinKitView;

public class InquirySahamActvity extends AppCompatActivity {
	WebView inquiry_saham_vewbview;
	Animation rotateAnimation;
	SpinKitView rotateImg;
	ImageView btn_back;
	TextView txt_inprogress,disable_txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inquiry_saham_actvity);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		rotateImg = findViewById(R.id.inquiry_imageView);
		txt_inprogress = findViewById(R.id.txt_inprogress);
		disable_txt = findViewById(R.id.vpn_inuery_txt_disable);

		btn_back = findViewById(R.id.img_back_inqery);
		//rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);
		//rotateImg.setAnimation(rotateAnimation);
		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {

				rotateImg.setVisibility(View.GONE);
				txt_inprogress.setVisibility(View.GONE);
				inquiry_saham_vewbview.setVisibility(View.VISIBLE);
				disable_txt.setVisibility(View.GONE);
			}
		}, 7000); // ----Main Activity Start After 3 Sec.

		inquiry_saham_vewbview = findViewById(R.id.inquiry_webview);
		inquiry_saham_vewbview.loadUrl("https://samanese.ir/start");

	WebSettings webSettings = inquiry_saham_vewbview.getSettings();
		webSettings.setJavaScriptEnabled(true);
	}
	@Override
	public void onBackPressed() {
		if (inquiry_saham_vewbview.canGoBack()){
			inquiry_saham_vewbview.goBack();
		}
		else {
			super.onBackPressed();

		}

	}
}