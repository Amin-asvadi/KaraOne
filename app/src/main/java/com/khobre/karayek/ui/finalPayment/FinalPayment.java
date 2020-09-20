package com.khobre.karayek.ui.finalPayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.khobre.karayek.R;
import com.khobre.karayek.ui.adapters.FinalPaymentAdapter;
import com.khobre.karayek.ui.databse.DbSql;
import com.khobre.karayek.ui.model.FInalPaymentModel;

import java.util.ArrayList;
import java.util.List;

public class FinalPayment extends AppCompatActivity {

    private FinalPaymentAdapter adapter;

    private List<FInalPaymentModel> fInalPaymentModelList;

    RecyclerView rc_payment;

    private DbSql dbSql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payment);
        rc_payment = findViewById(R.id.rc_payment_final);
        fInalPaymentModelList = new ArrayList<>();
        dbSql = new DbSql(this);
        fInalPaymentModelList = dbSql.ShowPayment();
        adapter = new FinalPaymentAdapter(this,fInalPaymentModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        rc_payment.setLayoutManager(linearLayoutManager);
        rc_payment.setAdapter(adapter);


    }
}