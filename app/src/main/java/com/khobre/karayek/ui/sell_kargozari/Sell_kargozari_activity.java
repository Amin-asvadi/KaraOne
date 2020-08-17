package com.khobre.karayek.ui.sell_kargozari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.khobre.karayek.R;
import com.github.ybq.android.spinkit.SpinKitView;

public class Sell_kargozari_activity extends AppCompatActivity {
    WebView webView;
    SpinKitView rotateImg;
    TextView txt_inprogress,disable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_kargozari_activity);
        rotateImg = findViewById(R.id.img_rotae_sell_kargozari);
txt_inprogress = findViewById(R.id.txt_inprogress_kargozari);
disable = findViewById(R.id.vpn_kargozari_txt_disable);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                txt_inprogress.setVisibility(View.GONE);
                rotateImg.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                disable.setVisibility(View.GONE);
            }
        }, 7000);  // ----Main Activity Start After 3 Sec.

        webView = findViewById(R.id.sell_kargozar_webView);
        webView.loadUrl("http://45.149.77.68/saham_edalat/saham_edalat_url");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){

            webView.goBack();
        }else{

            super.onBackPressed();
        }

    }

}