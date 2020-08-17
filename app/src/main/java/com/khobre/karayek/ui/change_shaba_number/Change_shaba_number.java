package com.khobre.karayek.ui.change_shaba_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.khobre.karayek.R;

public class Change_shaba_number extends AppCompatActivity {
    WebView change_shaba_number;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_shaba_number);
        change_shaba_number = findViewById(R.id.change_shaba_webView);
        change_shaba_number.loadUrl("https://samanese.ir/start");
     WebSettings webSettings = change_shaba_number.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
    @Override
    public void onBackPressed() {
        if (change_shaba_number.canGoBack()){
            change_shaba_number.goBack();
        }
        else {
            super.onBackPressed();

        }

    }
}