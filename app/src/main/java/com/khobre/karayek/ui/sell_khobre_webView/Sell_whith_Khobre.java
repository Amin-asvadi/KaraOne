package com.khobre.karayek.ui.sell_khobre_webView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.khobre.karayek.R;

public class Sell_whith_Khobre extends AppCompatActivity {
    EditText name;
    EditText phone_number;
    EditText person_id;
    Button btn_byt;
    Dialog dialog;
    TextView positve, nagetive, btn_ok;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        init();
      /*  Uri data = getIntent().getData();
        ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
            @Override
            public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
                if (isPaymentSuccess) {
                    Toast.makeText(Sell_whith_Khobre.this, "پرداخت با موفقیت انجام شد", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Sell_whith_Khobre.this, "پرداخت با وفقیت انجام نشد", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/

        btn_byt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mypayment();

            }
        });


    }

    private void mypayment() {
        String phone_num = phone_number.getText().toString();
        String personID = person_id.getText().toString();
        if (name.getText().toString().trim().equals("") || name.getText().toString().trim().length() < 5) {
            name.setError("نام وارد شده کوتاه میباشد");
        } else if (phone_number.getText().toString().trim().equals("") || phone_number.getText().toString().trim().length() < 11 || !phone_num.matches("(\\+98|0)?9\\d{9}")) {
            phone_number.setError("شماره موبایل اشتباه است ");
        } else if (person_id.getText().toString().trim().equals("") || person_id.getText().toString().trim().length() < 10) {


            person_id.setError("شماه ملی اشتباه است");
        } else {

            char[] chars = personID.toCharArray();
            int sum = 0;
            for (int i = 8; i >= 0; i--) {
                sum += Integer.parseInt(String.valueOf(chars[i])) * (10 - i);

            }

            int Re = sum % 11;
            if (Re>= 2){
                Re = 11 - Re;

            }

            if (Re == Integer.parseInt(String.valueOf(chars[9]))){

            }
            else{
                person_id.setError("شماره ملی صحیح وارد نمایید");
            }

            dialog.setContentView(R.layout.layout_alert_positive_or_nagetive);
            positve = dialog.findViewById(R.id.btn_positive);
            nagetive = dialog.findViewById(R.id.btn_nagetive);
            positve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /////// send to payment method///////////


                    Dialog dialogOk = new Dialog(Sell_whith_Khobre.this);
                    dialogOk.setContentView(R.layout.layout_accepted_dialog);
                    btn_ok = dialogOk.findViewById(R.id.btn_positive_accept);
                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogOk.dismiss();
                            name.setText("");
                            phone_number.setText("");
                            person_id.setText("");
                            dialog.dismiss();

                        }
                    });
                    dialogOk.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialogOk.show();
                    ;

              /*      PaymentRequest payment = ZarinPal.getPaymentRequest();
                    payment.setMerchantID("f9808e34-5540-11ea-a2a5-000c295eb8fc");
                    payment.setAmount(1000);
                    payment.setDescription("فروش سهام عدالت توسط کارشناس");
                    payment.setCallbackURL("doniyakhobre://kara1975");

                    ZarinPal.getPurchase(getApplicationContext()).startPayment(payment, new OnCallbackRequestPaymentListener() {
                        @Override
                        public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                            if (status == 100) {
                                Toast.makeText(Sell_whith_Khobre.this, "intent", Toast.LENGTH_SHORT).show();

                                startActivity(intent);
                            } else {
                                Toast.makeText(Sell_whith_Khobre.this, "خطا در ایجاد درخواست پرداخت", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    dialog.dismiss();*/
                }

            });
            nagetive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialogDenide = new Dialog(Sell_whith_Khobre.this);
                    dialogDenide.setContentView(R.layout.layout_denid_dialog);
                    btn_ok = dialogDenide.findViewById(R.id.btn_positive_denide);
                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogDenide.dismiss();
                        }
                    });
                    dialogDenide.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialogDenide.show();
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