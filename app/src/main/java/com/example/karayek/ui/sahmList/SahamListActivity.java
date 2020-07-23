package com.example.karayek.ui.sahmList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.karayek.MainActivity;
import com.example.karayek.R;

import java.util.ArrayList;
import java.util.List;

public class SahamListActivity extends AppCompatActivity {

SahamListAdapter sahamListAdapter;
List<SahamListModel> sahamListItems;
SahamListModel sahamListModel;
RecyclerView rc_stock_value;
TextView txt_sum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saham_list);
		rc_stock_value = findViewById(R.id.rc_stock_value);
txt_sum = findViewById(R.id.sum_price);
	sahamListModel = new SahamListModel();

		sahamListItems = new ArrayList<>();
		for(int i = 0; i < 40 ; i++){

			sahamListItems.add(new SahamListModel("آهن","ذوب",5,173.000f,365.000f));
		}
		float sum  = 0;
		for (int i = 0 ;i < sahamListItems.size();i++){
			sum += sahamListItems.get(i).getStocksValue();

		}
		sahamListModel.setSum_price(sum);
		txt_sum.setText(String.valueOf(sum));


		sahamListAdapter = new SahamListAdapter(sahamListItems, SahamListActivity.this);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager
				(SahamListActivity.this,LinearLayoutManager.VERTICAL,false);
		rc_stock_value.setLayoutManager(linearLayoutManager);
		rc_stock_value.setAdapter(sahamListAdapter);


	}
}