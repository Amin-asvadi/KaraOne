package com.example.karayek.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.karayek.MainActivity;
import com.example.karayek.R;
import com.example.karayek.ui.change_shaba_number.Change_shaba_number;
import com.example.karayek.ui.ejectSaham.EjectSahamActivity;
import com.example.karayek.ui.inquirySahamActivity.InquirySahamActvity;
import com.example.karayek.ui.moblieNumber.MobileNumberActivity;
import com.example.karayek.ui.questactivity.QuestionActivity;
import com.example.karayek.ui.sahmList.SahamListActivity;
import com.example.karayek.ui.sahmList.SahamListModel;
import com.example.karayek.ui.sell_activity.SellActivity;
import com.example.karayek.ui.splashScreen.SplashScreen;
import com.robinhood.ticker.TickerView;

import java.text.DecimalFormat;

public class HomeFragment extends Fragment implements View.OnClickListener {

	private LinearLayout btn_change_number;
	private LinearLayout btn_list_saham;
	private LinearLayout btn_sell_saham;
	private LinearLayout btn_change_shaba_number;
	private LinearLayout btn_eject_saham;
	private LinearLayout btn_inquiry_saham;
	private LinearLayout btn_quset;
	SahamListModel sahamListModel;
	View root;
	TickerView tv_saham_price;
	TickerView tv_saham_arzesh;

	private HomeViewModel homeViewModel;

	public View onCreateView(@NonNull LayoutInflater inflater,
	                         ViewGroup container, Bundle savedInstanceState) {
		homeViewModel =
				ViewModelProviders.of(this).get(HomeViewModel.class);
		root = inflater.inflate(R.layout.fragment_home_final, container, false);
	//	sahamListModel = new SahamListModel();
		tv_saham_price = root.findViewById(R.id.tv_saham_price);
		tv_saham_arzesh = root.findViewById(R.id.tv_saham_arzesh);


		tv_saham_price.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
		tv_saham_arzesh.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
		tv_saham_price.setText("0");
		tv_saham_arzesh.setText("0");
		new Handler().postDelayed(new Runnable() {


			@Override
			public void run() {
				DecimalFormat saham_price_decimal = new DecimalFormat("###,###,###");
				String saham_price = saham_price_decimal.format(205633386);
				String saham_arzesh = saham_price_decimal.format(411266772);
				//final String saham_price = Integer.toString(189398594);
				//final String saham_arzesh = Integer.toString(378797188);
				tv_saham_price.setText(saham_price.substring(0, Math.min(11, saham_price.length())));
				tv_saham_arzesh.setText(saham_arzesh.substring(0, Math.min(11, saham_arzesh.length())));
			}
		}, 2000); // ----Main Activity Start After 3 Sec.


		init();


		return root;
	}

	private void init() {
		//btn_change_number = root.findViewById(R.id.btn_change_number);
		btn_list_saham = root.findViewById(R.id.btn_list_saham);
		btn_sell_saham = root.findViewById(R.id.btn_sell_saham);
		btn_quset = root.findViewById(R.id.quest_motedavel);
		//btn_eject_saham = root.findViewById(R.id.btn_eject_saham);
		//btn_change_shaba_number = root.findViewById(R.id.btn_change_shaba_number);
		btn_list_saham.setOnClickListener(this);
		btn_inquiry_saham = root.findViewById(R.id.btn_inquiry_saham);
		//btn_change_number.setOnClickListener(this);
		btn_sell_saham.setOnClickListener(this);
		//btn_change_shaba_number.setOnClickListener(this);
		//btn_eject_saham.setOnClickListener(this);
		btn_inquiry_saham.setOnClickListener(this);
		btn_quset.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_list_saham:
				Intent btn_saham = new Intent(getContext(), SahamListActivity.class);
				startActivity(btn_saham);
				break;
			/*case R.id.btn_change_number:
				Intent btn_change_number = new Intent(getContext(), MobileNumberActivity.class);
				startActivity(btn_change_number);
				break;*/

			case R.id.btn_sell_saham:
				Intent btn_sell_saham = new Intent(getContext(), SellActivity.class);
				startActivity(btn_sell_saham);
				break;
		/*	case R.id.btn_change_shaba_number:
				Intent btn_change_shaba_number = new Intent(getContext(), Change_shaba_number.class);
				startActivity(btn_change_shaba_number);
				break;*/

			/*case R.id.btn_eject_saham:
				Intent btn_eject_saham = new Intent(getContext(), EjectSahamActivity.class);
				startActivity(btn_eject_saham);
				break;*/
			case R.id.btn_inquiry_saham:
				Intent btn_inquiry_saham = new Intent(getContext(), InquirySahamActvity.class);
				startActivity(btn_inquiry_saham);
				break;
			case R.id.quest_motedavel:
				Intent quest_motedavel = new Intent(getContext(), QuestionActivity.class);
				startActivity(quest_motedavel);
				break;
		}

	}
}