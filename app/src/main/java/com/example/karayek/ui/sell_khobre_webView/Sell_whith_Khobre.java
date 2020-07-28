package com.example.karayek.ui.sell_khobre_webView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.karayek.R;

public class Sell_whith_Khobre extends AppCompatActivity {
WebView webView;
    ImageView rotateImg;
    Animation rotateAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_whith__khobre);
        rotateImg = findViewById(R.id.img_rotae_sell_donya);

        rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        rotateImg.setAnimation(rotateAnimation);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                rotateImg.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        }, 7000);  // ----Main Activity Start After 3 Sec.

        webView = findViewById(R.id.sell_donya_khobre_webView);
        webView.loadUrl("http://mashhadburse.ir/product/consultation-request/");
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