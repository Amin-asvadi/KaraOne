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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khobre.karayek.ui.model.FInalPaymentModel;
import com.khobre.karayek.util.IabHelper;
import com.khobre.karayek.util.IabResult;
import com.khobre.karayek.util.Inventory;
import com.khobre.karayek.util.Purchase;
import com.khobre.karayek.R;
import com.khobre.karayek.ui.Network.ApiClient;
import com.khobre.karayek.ui.Network.RetrofitApiInterface;
import com.khobre.karayek.ui.databse.DbSql;
import com.khobre.karayek.ui.model.Price;
import com.khobre.karayek.ui.model.Users;

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
    Uri data;
    Context context = this;
    private DbSql dbSQL = new DbSql(context);
    private List<Price> paymentModelsItems = new ArrayList<>();
    String uri = "http://45.149.77.68/saham_edalat/";
    RetrofitApiInterface request;
    int price;
    private boolean mBazaarInstalled;

    // SKUs for our products: the premium upgrade (non-consumable)
    static final String SKU_PREMIUM = "register";

    // Does the user have the premium upgrade?
    boolean mIsPremium = false;
    private List<FInalPaymentModel> fInalPaymentModelList;
    // (arbitrary) request code for the purchase flow
    static final int RC_REQUEST = 10001 ;
    private static final String TAG = Sell_whith_Khobre.class.getSimpleName() + "TAG";

    // The helper object
    IabHelper mHelper;

    TextView priceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);
        init();
        fInalPaymentModelList = new ArrayList<>();
        fInalPaymentModelList = dbSQL.ShowPayment();
        request = ApiClient.getApiClient(uri).create(RetrofitApiInterface.class);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        paymentModelsItems = dbSQL.ShowPrice();
        price = Integer.valueOf(paymentModelsItems.get(0).getPrice());



        btn_byt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameStr = name.getText().toString();
                personIdStr = person_id.getText().toString();
                phoneStr = phone_number.getText().toString();

               mypayment();

            }
        });


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
        String base64EncodedPublicKey = "MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDq04CFsL0WCAOIATc1u4QxyjI32BkZ4RwNFDQs8i4TQXCnsD0/5cfYlf07Vnm9e22Xlh+Hm+CYpaJw7kCwSyqRZ0kWENeAx8sWMR2LTcAsahJEoQX1rw5UVsQlNOdf3AhwfZejsQtzFB+RenT95hwz9QlBgT+d6GaikJ4XPgIN6TkVk53DFNw+5zmumbwgY94zGugbJCTJ0UtPZELUIG0GuY5XlbvNsd4RD4PmwXsCAwEAAQ==";
        mHelper = new IabHelper(this, base64EncodedPublicKey);
        Log.d(TAG, "Starting setup.");

        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                //mProgressDialog.dismiss();
                mBazaarInstalled = true;
                Log.d(TAG, "Setup finished.");

                if (!result.isSuccess()) {
                    // moshkeli dar ertebat ba bazaar pish amad
                    Log.e("TAG", "failed to access bazaar " + result);


                }
                Log.e(TAG, "Problem setting up In-app Billing: " + result);
                mHelper.queryInventoryAsync(mGotInventoryListener);



            }
        });


    }

    ////////////////////////FOR BAZAAR CLASS ////////////////////////////////////

    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");
            if (mHelper == null) return;

            if (result.isFailure()) {
                // moshkeli dar ertebat ba bazaar pish amad
                Log.e("TAG", "failed to access bazaar " + result.getMessage());
                return;
            }else {

                Purchase premiumPurchase = inventory.getPurchase(SKU_PREMIUM);
                mIsPremium = (premiumPurchase != null && verifyDeveloperPayload(premiumPurchase));
                Purchase gasPurchase = inventory.getPurchase(SKU_PREMIUM);
                if (gasPurchase != null && verifyDeveloperPayload(gasPurchase)) {
                    Log.d(TAG, "We have gas. Consuming it.");
                    mHelper.consumeAsync(inventory.getPurchase(SKU_PREMIUM), mConsumeFinishedListener);
                    return;
                }
                Log.d(TAG, "Initial inventory query finished; enabling main UI.");
            }



        }
    };


    boolean verifyDeveloperPayload(Purchase p) {
        String payload = p.getDeveloperPayload();

        /*
         * TODO: verify that the developer payload of the purchase is correct. It will be
         * the same one that you sent when initiating the purchase.
         *
         * WARNING: Locally generating a random string when starting a purchase and
         * verifying it here might seem like a good approach, but this will fail in the
         * case where the user purchases an item on one device and then uses your app on
         * a different device, because on the other device you will not have access to the
         * random string you originally generated.
         *
         * So a good developer payload has these characteristics:
         *
         * 1. If two different users purchase an item, the payload is different between them,
         *    so that one user's purchase can't be replayed to another user.
         *
         * 2. The payload must be such that you can verify it even when the app wasn't the
         *    one who initiated the purchase flow (so that items purchased by the user on
         *    one device work on other devices owned by the user).
         *
         * Using your own server to store and verify developer payloads across app
         * installations is recommended.
         */

        return true;
    }
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            if (result.isFailure()) {
                Log.e("TAG", "failed to access bazaar " + result);
                return;
            } else if (purchase.getSku().equals(SKU_PREMIUM)) {
               mHelper.consumeAsync(purchase, mConsumeFinishedListener);

            }
        }
    };

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase, IabResult result) {
                    if (result.isSuccess()) {
                        insertToDatabseOnline(nameStr, phoneStr, personIdStr);
                        for (int i = 0 ; i <fInalPaymentModelList.size();i++){

                            dbSQL.UpadteFinalPayment(new FInalPaymentModel(nameStr,phoneStr,personIdStr,"پرداخت شده"), i + 1);
                        }

                       /* Dialog dialogacc = new Dialog(Sell_whith_Khobre.this);
                        dialogacc.setContentView(R.layout.layout_accepted_dialog);
                        btn_ok = dialogacc.findViewById(R.id.btn_positive_accept);
                        btn_ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogacc.dismiss();
                            }
                        });
                        dialogacc.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialogacc.show();*/
                        // provision the in-app purchase to the user
                        // (for example, credit 50 gold coins to player's character)
                    } else {
                        // handle error
                    }
                }
            };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        } else {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null && mBazaarInstalled) mHelper.dispose();
        mHelper = null;
    }

    private void insertToDatabseOnline(String nameStr, String phoneStr, String personIdStr) {
        Users users = new Users();
        users.setName(nameStr);
        users.setNational_number(personIdStr);
        users.setPhone_number(phoneStr);

        Call<ResponseBody> call = request.setData(users);


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                } else {

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Sell_whith_Khobre.this, t.getMessage() + "", Toast.LENGTH_SHORT).show();
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
            if (Re >= 2) {
                Re = 11 - Re;

            }

            if (Re == Integer.parseInt(String.valueOf(chars[9]))) {
                dialog.setContentView(R.layout.layout_alert_positive_or_nagetive);
                positve = dialog.findViewById(R.id.btn_positive);
                nagetive = dialog.findViewById(R.id.btn_nagetive);
                /////// send to payment method///////////
                priceText = dialog.findViewById(R.id.txt_price);
                priceText.setText(String.valueOf(price));
                positve.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
                    @Override
                    public void onClick(View v) {


                       String payload = "payload-string";
                        mHelper.launchPurchaseFlow(Sell_whith_Khobre.this, SKU_PREMIUM, RC_REQUEST,
                                mPurchaseFinishedListener, payload);
                        dbSQL.InsertToFinalPayment(new FInalPaymentModel(nameStr,phoneStr,personIdStr,"پرداخت نشده"));
                        dialog.dismiss();


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

            } else {
                person_id.setError("شماره ملی صحیح وارد نمایید");
            }


        }
    }

}