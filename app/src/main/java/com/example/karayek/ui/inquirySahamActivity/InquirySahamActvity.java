package com.example.karayek.ui.inquirySahamActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.karayek.R;

public class InquirySahamActvity extends AppCompatActivity {
	WebView inquiry_saham_vewbview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inquiry_saham_actvity);
		inquiry_saham_vewbview = findViewById(R.id.inquiry_webview);
		inquiry_saham_vewbview.loadUrl("https://panel.sahamedalat.ir/auth/login");
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