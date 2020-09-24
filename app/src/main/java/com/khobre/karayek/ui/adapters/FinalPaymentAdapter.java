package com.khobre.karayek.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khobre.karayek.R;
import com.khobre.karayek.ui.model.FInalPaymentModel;

import java.util.List;

public class FinalPaymentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<FInalPaymentModel> data;

    public FinalPaymentAdapter(Context context, List<FInalPaymentModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolderFinalPayment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_status,parent,false);
        return new  ViewHolderFinalPayment(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        FInalPaymentModel model = data.get(position);

        final ViewHolderFinalPayment vh = (ViewHolderFinalPayment) holder;

        vh.txt_name.setText(model.getName());
        vh.txt_phone_number.setText(model.getNumber());
        vh.txt_id_number.setText(model.getId_number());
        vh.txt_status.setText(model.getStatus());
        if (model.getStatus().equals("پرداخت نشده")){

            vh.txt_status.setTextColor(Color.parseColor("#F50029"));
            
        }else {

            vh.txt_status.setTextColor(Color.parseColor("#36ac0b"));
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolderFinalPayment extends RecyclerView.ViewHolder {


        TextView txt_name,txt_phone_number,txt_id_number,txt_status;

        public ViewHolderFinalPayment(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.txt_name_fname);
            txt_id_number = itemView.findViewById(R.id.txt_id_number);
            txt_phone_number = itemView.findViewById(R.id.txt_phone_number);
            txt_status = itemView.findViewById(R.id.txt_status);

        }
    }
}
