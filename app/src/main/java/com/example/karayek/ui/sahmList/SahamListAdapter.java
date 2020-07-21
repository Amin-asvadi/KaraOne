package com.example.karayek.ui.sahmList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.karayek.R;

import java.util.List;

public class SahamListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private List<SahamListModel> items;
	private Context context;

	public SahamListAdapter(List<SahamListModel> items, Context context) {
		this.items = items;
		this.context = context;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sahm_list,parent,false);

		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

 SahamListModel sahamListModel = items.get(position);
 final ViewHolder vh = (ViewHolder) holder;
 vh.list_group.setText(sahamListModel.getGroup());
 vh.title_sahm.setText(sahamListModel.getTitle());
 vh.list_count.setText(String.valueOf(sahamListModel.getCount()));
 vh.live_price.setText(String.valueOf(sahamListModel.getLivePrice()));
 vh.stocks_value.setText(String.valueOf(sahamListModel.getStocksValue()));
/*
		float sum  = 0;
 for (int i = 0 ;i < items.size();i++){
 	sum += items.get(i).getStocksValue();

 }
		sahamListModel.setSum_price(sum);
*/

	}

	@Override
	public int getItemCount() {
		return items.size();
	}
}
class ViewHolder extends RecyclerView.ViewHolder {
	 TextView list_group;
	 TextView title_sahm;
	 TextView list_count;
	 TextView live_price;
	 TextView stocks_value;
	public ViewHolder(@NonNull View itemView) {
		super(itemView);
		list_group = itemView.findViewById(R.id.list_group);
		title_sahm = itemView.findViewById(R.id.title_sahm);
		list_count = itemView.findViewById(R.id.list_count);
		live_price = itemView.findViewById(R.id.live_price);
		stocks_value = itemView.findViewById(R.id.stocks_value);


	}
}
