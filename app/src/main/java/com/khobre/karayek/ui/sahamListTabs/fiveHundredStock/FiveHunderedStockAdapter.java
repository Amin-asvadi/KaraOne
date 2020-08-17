package com.khobre.karayek.ui.sahamListTabs.fiveHundredStock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khobre.karayek.R;
import com.khobre.karayek.ui.sahmList.SahamListModel;

import java.text.DecimalFormat;
import java.util.List;

public class FiveHunderedStockAdapter extends RecyclerView.Adapter {

    private List<SahamListModel> items;
    private Context context;

    public FiveHunderedStockAdapter(List<SahamListModel> items, Context context) {
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderFiveHundred onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sahm_list, parent, false);

        return new ViewHolderFiveHundred(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SahamListModel sahamListModel = items.get(position);

        //SahamListModel sm = new SahamListModel();
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");

        final ViewHolderFiveHundred vh = (ViewHolderFiveHundred) holder;
        vh.list_group.setText(sahamListModel.getGroup());
        vh.title_sahm.setText(sahamListModel.getTitle());
        vh.list_count.setText(String.valueOf(sahamListModel.getCount()));
        String live_price = decimalFormat.format(Integer.valueOf(sahamListModel.getLivePrice()) );
        vh.live_price.setText(live_price);

        String stocks_value = decimalFormat.format((Integer.valueOf(sahamListModel.getStocksValue())));

        vh.stocks_value.setText(stocks_value);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class ViewHolderFiveHundred extends RecyclerView.ViewHolder {
    TextView list_group;
    TextView title_sahm;
    TextView list_count;
    TextView live_price;
    TextView stocks_value;

    public ViewHolderFiveHundred(@NonNull View itemView) {
        super(itemView);
        list_group = itemView.findViewById(R.id.list_group);
        title_sahm = itemView.findViewById(R.id.title_sahm);
        list_count = itemView.findViewById(R.id.list_count);
        live_price = itemView.findViewById(R.id.live_price);
        stocks_value = itemView.findViewById(R.id.stocks_value);


    }
}
