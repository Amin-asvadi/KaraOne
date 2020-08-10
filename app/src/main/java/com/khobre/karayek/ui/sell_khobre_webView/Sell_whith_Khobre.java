package com.khobre.karayek.ui.sell_khobre_webView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khobre.karayek.R;
import com.khobre.karayek.ui.Network.ApiClient;
import com.khobre.karayek.ui.Network.RetrofitApiInterface;
import com.khobre.karayek.ui.databse.DbSql;
import com.khobre.karayek.ui.model.PaymentModel;
import com.khobre.karayek.ui.model.Users;
import com.khobre.karayek.ui.sahmList.SahamListModel;
import com.zarinpal.ewallets.purchase.OnCallbackRequestPaymentListener;
import com.zarinpal.ewallets.purchase.OnCallbackVerificationPaymentListener;
import com.zarinpal.ewallets.purchase.PaymentRequest;
import com.zarinpal.ewallets.purchase.ZarinPal;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sell_whith_Khobre extends AppCompatActivity {
    EditText name;
    EditText phone_number;
    EditText person_id;
    Button btn_byt;
    Dialog dialog;
    TextView positve, nagetive, btn_ok;
    ImageView back;

   private static String nameStr;
    private static String phoneStr;
   private static String personIdStr;
    Uri  data;
    Context context = this;
    private DbSql dbSQL = new DbSql(context);
    private List<PaymentModel> paymentModelsItems = new ArrayList<>();
    String uri = "http://45.149.77.68/saham_edalat/";
    RetrofitApiInterface request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);

        request = ApiClient.getApiClient(uri).create(RetrofitApiInterface.class);

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
        data =getIntent().getData();

        if (data!=null) {
            ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
                @Override
                public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
                    if (isPaymentSuccess) {
                        insertToDatabseOnline(nameStr,phoneStr,personIdStr);
                        Dialog dialogOk = new Dialog(Sell_whith_Khobre.this);
                    dialogOk.setContentView(R.layout.layout_accepted_dialog);
                    btn_ok = dialogOk.findViewById(R.id.btn_positive_accept);
                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogOk.dismiss();

                        }
                    });
                    dialogOk.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialogOk.show();
                        ;

                       /* Toast.makeText(Sell_whith_Khobre.this,  phoneStr +refID, Toast.LENGTH_SHORT).show();*/
                        //tv.setText( "موفق " + refID);
                        //   Log.i("TAG", refID);
                        Toast.makeText(Sell_whith_Khobre.this, "موفق", Toast.LENGTH_LONG).show();
                        Dialog dialogacc = new Dialog(Sell_whith_Khobre.this);
                        dialogacc.setContentView(R.layout.layout_accepted_dialog);
                    btn_ok = dialogacc.findViewById(R.id.btn_positive_accept);
                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogacc.dismiss();
                      /*      name.setText("");
                            phone_number.setText("");
                            person_id.setText("");*/
                            //dialog.dismiss();

                        }
                    });
                    dialogOk.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialogOk.show();


                    } else {
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
                  /*      Toast.makeText(Sell_whith_Khobre.this,  "ناموفق" , Toast.LENGTH_SHORT).show();*/
                        //  Log.i("TAG", refID);
                        // MainActivity.this.getIntent().setData(null);
                    }
                }


            });
        }else {
            //tv.setText("recieved data is ");
           /* Toast.makeText(this, "recieved data is null", Toast.LENGTH_SHORT).show();*/
        }

        btn_byt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = name.getText().toString();
                personIdStr = person_id.getText().toString();
                phoneStr = phone_number.getText().toString();

                mypayment();
              //insertDatabase();
               // payment(30000L);

            }
        });


    }

    private void insertToDatabseOnline(String nameStr,String phoneStr,String personIdStr) {
        Users users = new Users();
        users.setName(nameStr);
        users.setNational_number(personIdStr);
        users.setPhone_number(phoneStr);

        Call<ResponseBody> call = request.setData(users);



call.enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()){

        }else{

        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Toast.makeText(Sell_whith_Khobre.this, t.getMessage() + "", Toast.LENGTH_SHORT).show();
    }
});
    }

    private void insertDatabase() {

        dbSQL.InsertPersonPayment(new PaymentModel(name.getText().toString(),phone_number.getText().toString(),person_id.getText().toString()));
    }
    private void    ShowDatabase(){

        paymentModelsItems = dbSQL.ShowPersonPayment();

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private void payment(){
        try {
            ZarinPal purchase=ZarinPal.getPurchase(Sell_whith_Khobre.this);
            PaymentRequest paymentRequest=ZarinPal.getPaymentRequest();
            paymentRequest.setMerchantID("f9808e34-5540-11ea-a2a5-000c295eb8fc");
            paymentRequest.setAmount(30000L);
            paymentRequest.setCallbackURL("retuern://zarinpalpayment");
            paymentRequest.setDescription("پرداخت تست");
            purchase.startPayment(paymentRequest, new OnCallbackRequestPaymentListener() {
                @Override
                public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                    if (status==100){

                        startActivity(intent);
                        // Log.i("TAG","succes");
                    }else {
                        Toast.makeText(Sell_whith_Khobre.this, "خطا در ایجاد درخواست", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

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
                dialog.setContentView(R.layout.layout_alert_positive_or_nagetive);
                positve = dialog.findViewById(R.id.btn_positive);
                nagetive = dialog.findViewById(R.id.btn_nagetive);
                positve.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
                    @Override
                    public void onClick(View v) {
                        /////// send to payment method///////////





                        dialog.dismiss();
                        payment();



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
            else{
                person_id.setError("شماره ملی صحیح وارد نمایید");
            }



        }
    }
    private void SendData(String nameStr,String phoneStr,String personIdStr) {





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