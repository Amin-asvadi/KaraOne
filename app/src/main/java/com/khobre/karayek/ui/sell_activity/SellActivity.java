package com.khobre.karayek.ui.sell_activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.khobre.karayek.R;
import com.khobre.karayek.ui.databse.DbSql;
import com.khobre.karayek.ui.sahmList.SahamListModel;
import com.khobre.karayek.ui.sell_kargozari.Sell_kargozari_activity;
import com.khobre.karayek.ui.sell_khobre_webView.SellKhobrePaymentWebActivity;
import com.khobre.karayek.ui.sell_khobre_webView.Sell_whith_Khobre;
import com.robinhood.ticker.TickerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SellActivity extends AppCompatActivity {
	LinearLayout btn_sell_noya_khobre,btn_sell_kargozri;
	ImageView img_back;
	TickerView tv_saham_price;
	TickerView tv_saham_arzesh;
	private List<SahamListModel> sahamListItems = new ArrayList<>();
	private DbSql dbSQL ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		dbSQL = new DbSql(this);
		sahamListItems = dbSQL.ShowData();

		init();
img_back = findViewById(R.id.img_back);
img_back.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		finish();
	}
});
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
				Intent intent = new Intent(SellActivity.this, SellKhobrePaymentWebActivity.class);
				startActivity(intent);
			}
		});



		txtViewAnimation();
	}

	private void init() {
		tv_saham_price = findViewById(R.id.tv_nim_melion);
		tv_saham_arzesh = findViewById(R.id.tv_yek_melioon);
	}

	private void txtViewAnimation() {
		tv_saham_price.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
		tv_saham_arzesh.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
		tv_saham_price.setText("0");
		tv_saham_arzesh.setText("0");
		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {
				DecimalFormat saham_price_decimal = new DecimalFormat("###,###,###");
				int sumSahm = Integer.valueOf(sahamListItems.get(1).getSum_price());
				String saham_price = saham_price_decimal.format((sumSahm / 100)  * 30);
				String saham_arzesh = saham_price_decimal.format(((sumSahm  * 2) / 100 ) * 30);
				//final String saham_price = Integer.toString(189398594);
				//final String saham_arzesh = Integer.toString(378797188);
				tv_saham_price.setText(saham_price.substring(0, Math.min(11, saham_price.length())));
				tv_saham_arzesh.setText(saham_arzesh.substring(0, Math.min(11, saham_arzesh.length())));
			}
		}, 2000); // ----Main Activity Start After 3 Sec.
	}
}