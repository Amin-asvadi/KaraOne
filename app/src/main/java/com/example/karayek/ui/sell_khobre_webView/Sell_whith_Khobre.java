package com.example.karayek.ui.sell_khobre_webView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.karayek.R;
import com.github.ybq.android.spinkit.SpinKitView;
import com.zarinpal.ewallets.purchase.OnCallbackRequestPaymentListener;
import com.zarinpal.ewallets.purchase.OnCallbackVerificationPaymentListener;
import com.zarinpal.ewallets.purchase.PaymentRequest;
import com.zarinpal.ewallets.purchase.ZarinPal;

public class Sell_whith_Khobre extends AppCompatActivity {
    EditText name;
    EditText phone_number;
    EditText person_id;
    Button btn_byt;
    Dialog dialog;
    TextView positve, nagetive;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        init();
Uri data = getIntent().getData();
ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
    @Override
    public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
        if (isPaymentSuccess){
            Toast.makeText(Sell_whith_Khobre.this, "پرداخت با موفقیت انجام شد", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(Sell_whith_Khobre.this, "پرداخت با وفقیت انجام نشد", Toast.LENGTH_SHORT).show();
        }
    }
});





        btn_byt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mypayment();

            }
        });


    }

    private void mypayment() {
        if (name.getText().toString().trim().equals("") || name.getText().toString().trim().length() < 5) {
            name.setError("لطفا مقادیر را پر کنید");
        } else if (phone_number.getText().toString().trim().equals("") || phone_number.getText().toString().trim().length() < 10) {
            phone_number.setError("لطفا مقادیر را پر کنید");
        } else if (person_id.getText().toString().trim().equals("") || person_id.getText().toString().trim().length() < 10) {

            person_id.setError("لطفا مقادیر را پر کنید");
        } else {

            dialog.setContentView(R.layout.layout_alert_positive_or_nagetive);
            positve = dialog.findViewById(R.id.btn_positive);
            nagetive = dialog.findViewById(R.id.btn_nagetive);
            positve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /////// send to payment method///////////


                    PaymentRequest payment =ZarinPal.getPaymentRequest();
                    //payment.setMerchantID("3e7108f0-4a7e-11e7-9354-005056a205be");
                    payment.setMerchantID("f9808e34-5540-11ea-a2a5-000c295eb8fc");
                    payment.setAmount(1000);
                    payment.setDescription("فروش سهام عدالت توسط کارشناس");
                    payment.setCallbackURL("app://app");

                    ZarinPal.getPurchase(getApplicationContext()).startPayment(payment, new OnCallbackRequestPaymentListener() {
                        @Override
                        public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                            startActivity(intent);

                           /* if (status == 100){
                                Toast.makeText(Sell_whith_Khobre.this, "intent", Toast.LENGTH_SHORT).show();

                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(Sell_whith_Khobre.this, "خطا در ایجاد درخواست پرداخت", Toast.LENGTH_SHORT).show();
                            }*/
                        }
                    });

                }

            });
            nagetive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
           dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();


        }
    }

    private void init() {
        name = findViewById(R.id.ed_input_name);
        phone_number = findViewById(R.id.ed_phone_number);
        person_id = findViewById(R.id.ed_input_person_id);
        btn_byt = findViewById(R.id.btn_buy);
        back = findViewById(R.id.img_back_sell);
        dialog = new Dialog(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}