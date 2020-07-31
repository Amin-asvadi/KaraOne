package com.example.karayek.ui.sahamListTabs.oneMelionStock;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.karayek.R;
import com.example.karayek.ui.databse.DbSql;
import com.example.karayek.ui.sahamListTabs.fiveHundredStock.FiveHunderedStockAdapter;
import com.example.karayek.ui.sahmList.SahamListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneMelioonStockFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneMelioonStockFragment extends Fragment {
    OneMElioonAdapter oneMElioonAdapter;
    private List<SahamListModel> sahamListItems;

    RecyclerView rc_stock_value;
    TextView txt_sum;

    private DbSql dbSQL;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OneMelioonStockFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneMelioonStock.
     */
    // TODO: Rename and change types and number of parameters
    public static OneMelioonStockFragment newInstance(String param1, String param2) {
        OneMelioonStockFragment fragment = new OneMelioonStockFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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
        txt_sum.setText(sahamListItems.get(1).getSum_price());
        return root;

    }
}