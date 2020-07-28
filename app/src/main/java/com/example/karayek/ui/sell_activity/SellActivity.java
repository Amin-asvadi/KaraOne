package com.example.karayek.ui.sell_activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.karayek.R;
import com.example.karayek.ui.sell_kargozari.Sell_kargozari_activity;
import com.example.karayek.ui.sell_khobre_webView.Sell_whith_Khobre;

public class SellActivity extends AppCompatActivity {
	LinearLayout btn_sell_noya_khobre,btn_sell_kargozri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);

		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();

		btn_sell_noya_khobre = findViewById(R.id.btn_sell_mohsaver);
		btn_sell_kargozri = findViewById(R.id.btn_sell_kargozri);
		btn_sell_kargozri.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SellActivity.this, Sell_kargozari_activity.class);
				startActivity(intent);
			}
		});
		btn_sell_noya_khobre.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SellActivity.this, Sell_whith_Khobre.class);
				startActivity(intent);
			}
		});
	}
}