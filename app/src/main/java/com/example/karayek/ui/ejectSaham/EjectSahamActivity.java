package com.example.karayek.ui.ejectSaham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.karayek.R;

public class EjectSahamActivity extends AppCompatActivity {
    WebView eject_sham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eject_saham);
        eject_sham = findViewById(R.id.eject_saham_webview);
        eject_sham.loadUrl("https://samanese.ir/start");
        WebSettings webSettings = eject_sham.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if (eject_sham.canGoBack()){

            eject_sham.goBack();
        }else{

            super.onBackPressed();
        }

    }
}