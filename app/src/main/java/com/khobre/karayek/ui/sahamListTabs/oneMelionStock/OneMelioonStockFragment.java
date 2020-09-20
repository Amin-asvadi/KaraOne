package com.khobre.karayek.ui.sahamListTabs.oneMelionStock;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khobre.karayek.R;
import com.khobre.karayek.ui.databse.DbSql;
import com.khobre.karayek.ui.sahmList.SahamListModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class OneMelioonStockFragment extends Fragment {
    OneMElioonAdapter oneMElioonAdapter;
    private List<SahamListModel> sahamListItems;

    RecyclerView rc_stock_value;
    TextView txt_sum;

    private DbSql dbSQL;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
View root = inflater.inflate(R.layout.fragment_one_melioon_stock, container, false);
        txt_sum =root.findViewById(R.id.sum_price_one);
        rc_stock_value =root.findViewById(R.id.rc_stock_value_one);
        sahamListItems = new ArrayList<>();
        dbSQL = new DbSql(getActivity());
        sahamListItems = dbSQL.ShowDataOne();

        oneMElioonAdapter  =new OneMElioonAdapter(sahamListItems,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                (getContext(),LinearLayoutManager.VERTICAL,false);
        rc_stock_value.setLayoutManager(linearLayoutManager);
        rc_stock_value.setAdapter(oneMElioonAdapter);
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        String sumprice = decimalFormat.format(Integer.valueOf(sahamListItems.get(1).getSum_price()));
        txt_sum.setText(sumprice);
        return root;

    }
}