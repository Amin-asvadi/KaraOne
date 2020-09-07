package com.khobre.karayek;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.khobre.karayek.util.IabHelper;
import com.khobre.karayek.util.IabResult;
import com.khobre.karayek.util.Inventory;
import com.khobre.karayek.util.Purchase;

import butterknife.ButterKnife;

public class BuyActivity extends AppCompatActivity {


    //SweetAlertDialogCustom mProgressDialog;
    private boolean mBazaarInstalled;
    
    // SKUs for our products: the premium upgrade (non-consumable)
    static final String SKU_PREMIUM = "premium";

    // Does the user have the premium upgrade?
    boolean mIsPremium = false;

    // (arbitrary) request code for the purchase flow
    static final int RC_REQUEST = 1;
    private static final String TAG = BuyActivity.class.getSimpleName() + "TAG";

    // The helper object
    IabHelper mHelper;

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ButterKnife.bind(this);

        //neshan dadan progress bar
        //mProgressDialog = SweetAlertHelper.loadingSweetAlert(this, "در حال اتصال به بازار");
        String base64EncodedPublicKey = " MIHNMA0GCSqGSIb3DQEBAQUAA4G7ADCBtwKBrwDq04CFsL0WCAOIATc1u4QxyjI32BkZ4RwNFDQs8i4TQXCnsD0/5cfYlf07Vnm9e22Xlh+Hm+CYpaJw7kCwSyqRZ0kWENeAx8sWMR2LTcAsahJEoQX1rw5UVsQlNOdf3AhwfZejsQtzFB+RenT95hwz9QlBgT+d6GaikJ4XPgIN6TkVk53DFNw+5zmumbwgY94zGugbJCTJ0UtPZELUIG0GuY5XlbvNsd4RD4PmwXsCAwEAAQ== ";
        mHelper = new IabHelper(this, base64EncodedPublicKey);

        Log.d(TAG, "Starting setup.");

        try {
            mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
                public void onIabSetupFinished(IabResult result) {
                    //mProgressDialog.dismiss();
                    mBazaarInstalled = true;
                    Log.d(TAG, "Setup finished.");

                    if (!result.isSuccess()) {
                        // moshkeli dar ertebat ba bazaar pish amad
                        Log.e("TAG", "failed to access bazaar " + result);

						//neshan dad dialog khata be karbar(dar inja sweet alert)
                        /*new SweetAlertDialogCustom(BuyActivity.this, SweetAlertDialogCustom.CUSTOM_IMAGE_TYPE)
                                .setTitleText("کاربر گرامی")
                                .setContentText("خطایی در ارتباط با بازار رخ داد! از وصل بودن اینترنت خود مطمئن شوید.")
                                .setConfirmClickListener(new SweetAlertDialogCustom.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialogCustom sDialog) {
                                        finish();
                                    }
                                })
                                .show();*/
                        Log.e(TAG, "Problem setting up In-app Billing: " + result);

                    }

                        Toast.makeText(BuyActivity.this, "problem", Toast.LENGTH_SHORT).show();
                        mHelper.queryInventoryAsync(mGotInventoryListener);

                    // Hooray, IAB is fully set up!

                }
            });
        } catch (Exception ex) {
        	//bazaar ruye gooshie karbar nasb nist, bayad handle shavad
            mBazaarInstalled = false;

            //neshan dad dialog khata be karbar(dar inja sweet alert)
            /*new SweetAlertDialogCustom(BuyActivity.this, SweetAlertDialogCustom.CUSTOM_IMAGE_TYPE)
                    .setTitleText("کاربر گرامی")
                    .setContentText("برای خرید این اپلیکیشن باید برنامه کافه بازار را نصب کنید!")
                    .setConfirmClickListener(new SweetAlertDialogCustom.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialogCustom sDialog) {
                            finish();
                        }
                    })
                    .show();*/
        }


    }


    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");


            if (result.isFailure()) {
            	// moshkeli dar ertebat ba bazaar pish amad
                Log.e("TAG", "failed to access bazaar " + result.getMessage());
                //neshan dad dialog khata be karbar(dar inja sweet alert)
                /*new SweetAlertDialogCustom(BuyActivity.this, SweetAlertDialogCustom.CUSTOM_IMAGE_TYPE)
                        .setTitleText("کاربر گرامی")
                        .setContentText("خطایی در ارتباط با بازار رخ داد! از وصل بودن اینترنت خود مطمئن شوید.")
                        .setConfirmClickListener(new SweetAlertDialogCustom.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialogCustom sDialog) {
                                finish();
                            }
                        })
                        .show();*/
                return;
            } else {
                Log.d(TAG, "Query inventory was successful.");
                // does the user have the premium upgrade?
                //aya karbar noskhe premium ra ghablan kharide ast?
                mIsPremium = inventory.hasPurchase(SKU_PREMIUM);
                // update UI accordingly
                //agar kharide ast bayad mohtava barayash baz shavad
                if (mIsPremium) {
                    //barname be activity digari ke hedayat mishavad va mohtava baraye karbar baz mishavad
                    Intent intent = new Intent(BuyActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    try {
                        mHelper.launchPurchaseFlow(BuyActivity.this, SKU_PREMIUM, RC_REQUEST, mPurchaseFinishedListener, "payload-string");
                    } catch (Exception ex) {

                    }

                }

                Log.d(TAG, "User is " + (mIsPremium ? "PREMIUM" : "NOT PREMIUM"));
            }

            Log.d(TAG, "Initial inventory query finished; enabling main UI.");
        }
    };

    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            if (result.isFailure()) {
            	// moshkeli dar ertebat ba bazaar pish amad
                Log.e("TAG", "failed to access bazaar " + result);
                //neshan dad dialogE khata be karbar(dar inja sweet alert)
                /*new SweetAlertDialogCustom(BuyActivity.this, SweetAlertDialogCustom.CUSTOM_IMAGE_TYPE)
                        .setTitleText("کاربر گرامی")
                        .setContentText("خطایی در ارتباط با بازار رخ داد! از وصل بودن اینترنت خود مطمئن شوید.")
                        .setConfirmClickListener(new SweetAlertDialogCustom.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialogCustom sDialog) {
                                finish();
                            }
                        })
                        .show();*/
                return;
            } else if (purchase.getSku().equals(SKU_PREMIUM)) {
                // give user access to premium content and update the UI
                // be karbar dastrasi be mohtavaye premium(puli) ra bedahid. karbar kharid ra kamel anjam dad
                Intent intent = new Intent(BuyActivity.this, MainActivity.class);
                startActivity(intent);
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

}

