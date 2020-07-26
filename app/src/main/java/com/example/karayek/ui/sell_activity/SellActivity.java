package com.example.karayek.ui.sell_activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.karayek.R;

public class SellActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);

		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
	}
}