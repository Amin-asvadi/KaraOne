package com.khobre.karayek.ui.sell_khobre_webView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.khobre.karayek.R;

public class SellKhobrePaymentWebActivity extends AppCompatActivity {
    WebView webView;
    SpinKitView rotateImg;
    TextView txt_inprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_khobre_payment_web);
        rotateImg = findViewById(R.id.img_rotae_sell_khobre);
        txt_inprogress = findViewById(R.id.txt_inprogress_kargozari);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                txt_inprogress.setVisibility(View.GONE);
                rotateImg.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        },
                3000);  // ----Main Activity Start After 3 Sec.

        webView = findViewById(R.id.sell_khobre_webview);
        webView.loadUrl("http://mashhadburse.ir/form/");
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