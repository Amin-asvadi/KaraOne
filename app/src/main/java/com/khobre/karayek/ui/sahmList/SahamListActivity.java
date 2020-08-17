package com.khobre.karayek.ui.sahmList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.khobre.karayek.R;
import com.khobre.karayek.ui.databse.DbSql;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SahamListActivity extends AppCompatActivity {

SahamListAdapter sahamListAdapter;
 private List <SahamListModel> sahamListItems = new ArrayList<>();
SahamListModel sahamListModel;
Context context = this;
RecyclerView rc_stock_value;
TextView txt_sum;

	private DbSql dbSQL = new DbSql(context);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saham_list);

		init();

	/* sahamListModel = new SahamListModel();

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
		rc_stock_value.setAdapter(sahamListAdapter);*/

getNimMelioon();

	}

	private void init() {

		txt_sum = findViewById(R.id.sum_price);
		rc_stock_value =findViewById(R.id.rc_stock_value_five_hundred);
		sahamListItems = dbSQL.ShowData();

	}

	private void getNimMelioon() {

		sahamListAdapter  =new SahamListAdapter(sahamListItems,SahamListActivity.this);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager
				(SahamListActivity.this,LinearLayoutManager.VERTICAL,false);
		rc_stock_value.setLayoutManager(linearLayoutManager);
		rc_stock_value.setAdapter(sahamListAdapter);
		txt_sum.setText(sahamListItems.get(1).getSum_price());
	}

	private void getCompanies() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://mashhadburse.ir/kara1/client/v1/api/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		SahamListInterFace GroupService = retrofit.create(SahamListInterFace.class);
		Call<List<SahamListModel>> call = GroupService.getSahamList();

		call.enqueue(new Callback<List<SahamListModel>>() {
			@Override
			public void onResponse(Call<List<SahamListModel>> call, Response<List<SahamListModel>> response) {
				sahamListModel = new SahamListModel();
				if (response.isSuccessful()){
					List<SahamListModel> saham_Live = response.body();



					sahamListItems = (ArrayList<SahamListModel>) saham_Live;
					int sum  = 0;

					for (int j =0 ; j < saham_Live.size() ; j++){
						sum += (Integer.valueOf( saham_Live.get(j).getCount() )* Integer.valueOf(saham_Live.get(j).getLivePrice()) );

					}
					sahamListModel.setSum_price(String.valueOf(sum));
					DecimalFormat saham_price_decimal = new DecimalFormat("###,###,###");
					String saham_price = saham_price_decimal.format(sum);
					txt_sum.setText(saham_price);
					sahamListAdapter = new SahamListAdapter(sahamListItems,SahamListActivity.this);

					LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SahamListActivity.this, LinearLayoutManager.VERTICAL, false);
					rc_stock_value.setLayoutManager(linearLayoutManager);
					rc_stock_value.setAdapter(sahamListAdapter);

				}else {
					Log.e("ERROR",String.valueOf(response.code()));
					Toast.makeText(SahamListActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();

				}
			}

			@Override
			public void onFailure(Call<List<SahamListModel>> call, Throwable t) {
				Toast.makeText(SahamListActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

			}
		});

	}
}