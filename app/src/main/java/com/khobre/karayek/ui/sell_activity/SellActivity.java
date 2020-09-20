package com.khobre.karayek.ui.sell_activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.khobre.karayek.R;
import com.khobre.karayek.ui.ClsSharedPreference;
import com.khobre.karayek.ui.databse.DbSql;
import com.khobre.karayek.ui.sahmList.SahamListModel;
import com.khobre.karayek.ui.sell_kargozari.Sell_kargozari_activity;
import com.khobre.karayek.ui.sell_khobre_webView.SellKhobrePaymentWebActivity;
import com.khobre.karayek.ui.sell_khobre_webView.Sell_whith_Khobre;
import com.khobre.karayek.ui.splashScreen.SplashScreen;
import com.robinhood.ticker.TickerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SellActivity extends AppCompatActivity {
    LinearLayout btn_sell_noya_khobre, btn_sell_kargozri,line_saham_five,line_saham_one;
    ImageView img_back,btn_sell_info;
    TickerView tv_saham_price;
    TickerView tv_saham_arzesh;
    ClsSharedPreference prefManager;
    private List<SahamListModel> sahamListItems = new ArrayList<>();
    private DbSql dbSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        dbSQL = new DbSql(this);
        sahamListItems = dbSQL.ShowData();
        prefManager = new ClsSharedPreference(SellActivity.this);
        btn_sell_info = findViewById(R.id.btn_sell_info);
		line_saham_five = findViewById(R.id.line_saham_five);
        line_saham_one =findViewById(R.id.line_saham_one);

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
                Intent intent = new Intent(SellActivity.this, Sell_whith_Khobre.class);
                startActivity(intent);
            }
        });

if(prefManager.isFirstTimeLaunchّInfo()){
    tips();
    prefManager.setFirstTimeLaunchInfo(false);

}
        btn_sell_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tips();
            }
        });

        txtViewAnimation();
    }


    private void tips() {
        final Display display = getWindowManager().getDefaultDisplay();

        final Drawable droid = ContextCompat.getDrawable(this, R.drawable.ic_android_black_24dp);


        final Rect droidTarget = new Rect(0, 0, droid.getIntrinsicWidth() * 2, droid.getIntrinsicHeight() * 2);

        droidTarget.offset(display.getWidth() / 2, display.getHeight() / 2);

        final SpannableString sassyDesc = new SpannableString("It allows you to go back,somtimes");

        sassyDesc.setSpan(new StyleSpan(Typeface.ITALIC), sassyDesc.length() - "sometimes".length(), sassyDesc.length(), 0);


        final SpannableString kargozari_btn = new SpannableString("همین الان و به صورت آنلاین خودتان سهامتان را بفروشید");
        kargozari_btn.setSpan(new UnderlineSpan(), kargozari_btn.length() - "جزییات".length(), kargozari_btn.length(), 0);
        TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.card_sell_kargozari), "فروش آنلاین خودتان", kargozari_btn)
                .cancelable(false)
                .drawShadow(true)
                .titleTextDimen(R.dimen.title_text_size)
                .tintTarget(false), new TapTargetView.Listener() {
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);
				btn_khobre_info();
                // .. which evidently starts the sequence we defined earlier
            }

            @Override
            public void onOuterCircleClick(TapTargetView view) {
                super.onOuterCircleClick(view);
                Toast.makeText(view.getContext(), "دکمه را لمس کنید", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
            }
        });

    }

	private void btn_khobre_info() {


		final SpannableString khobre_btn = new SpannableString("اگر تخصص ندارید کارشناسان ما مراحل فروش سهام عدالت را برایتان انجام میدهند");
		khobre_btn.setSpan(new UnderlineSpan(), khobre_btn.length() - "جزییات".length(), khobre_btn.length(), 0);
		TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.card_bourse_yar), "فروش توسط کارشناسان", khobre_btn)
				.cancelable(false)
				.drawShadow(true)
				.titleTextDimen(R.dimen.title_text_size)
				.tintTarget(false), new TapTargetView.Listener() {
			@Override
			public void onTargetClick(TapTargetView view) {
				super.onTargetClick(view);

				show_saham_five_info();
				// .. which evidently starts the sequence we defined earlier
			}

			@Override
			public void onOuterCircleClick(TapTargetView view) {
				super.onOuterCircleClick(view);
				Toast.makeText(view.getContext(), "کلید را لمس کنید", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
			}
		});
	}






	private void show_saham_five_info() {


		final SpannableString khobre_btn = new SpannableString("اگر سهام عدالت 500 تومانی دارید تا این مبلغ از سهام خود را میتوانید بفروشید");
		khobre_btn.setSpan(new UnderlineSpan(), khobre_btn.length() - "جزییات".length(), khobre_btn.length(), 0);
		TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.line_saham_five), "سهام ۵۰۰ هزار تومانی", khobre_btn)
				.cancelable(false)
				.drawShadow(true)
				.titleTextDimen(R.dimen.title_text_size)
				.tintTarget(false), new TapTargetView.Listener() {
			@Override
			public void onTargetClick(TapTargetView view) {
				super.onTargetClick(view);
                show_saham_one_info();
				// .. which evidently starts the sequence we defined earlier
			}

			@Override
			public void onOuterCircleClick(TapTargetView view) {
				super.onOuterCircleClick(view);
				Toast.makeText(view.getContext(), "You clicked the outer circle!", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
				Log.d("TapTargetViewSample", "You dismissed me :(");
			}
		});
	}

    private void show_saham_one_info() {


        final SpannableString khobre_btn = new SpannableString("اگر سهام ۱ میلیون تومانی دارید تا این مبلغ از سهام عدالت خود را میتوانید بفروشید");
        khobre_btn.setSpan(new UnderlineSpan(), khobre_btn.length() - "جزییات".length(), khobre_btn.length(), 0);
        TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.line_saham_one), "سهام ۱ میلیون تومانی", khobre_btn)
                .cancelable(false)
                .drawShadow(true)
                .titleTextDimen(R.dimen.title_text_size)
                .tintTarget(false), new TapTargetView.Listener() {
            @Override
            public void onTargetClick(TapTargetView view) {
                super.onTargetClick(view);

                // .. which evidently starts the sequence we defined earlier
            }

            @Override
            public void onOuterCircleClick(TapTargetView view) {
                super.onOuterCircleClick(view);
                Toast.makeText(view.getContext(), "کلید را لمس کنید", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTargetDismissed(TapTargetView view, boolean userInitiated) {

            }
        });
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
                String saham_price = saham_price_decimal.format((sumSahm / 100) * 60);
                String saham_arzesh = saham_price_decimal.format(((sumSahm * 2) / 100) * 60);
                //final String saham_price = Integer.toString(189398594);
                //final String saham_arzesh = Integer.toString(378797188);
                tv_saham_price.setText(saham_price.substring(0, Math.min(11, saham_price.length())));
                tv_saham_arzesh.setText(saham_arzesh.substring(0, Math.min(11, saham_arzesh.length())));
            }
        }, 2000); // ----Main Activity Start After 3 Sec.
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}