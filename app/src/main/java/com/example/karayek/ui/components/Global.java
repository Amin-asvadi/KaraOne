package com.example.karayek.ui.components;


import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.karayek.ui.ClsSharedPreference;
import com.example.karayek.ui.Network.AppModule;
import com.example.karayek.ui.Network.ApplicationComponent;
import com.example.karayek.ui.Network.ApplicationModule;
import com.example.karayek.ui.Network.DaggerApplicationComponent;
import com.example.karayek.ui.Network.DaggerNetComponent;
import com.example.karayek.ui.Network.NetComponent;
import com.example.karayek.ui.Network.NetModule;
import com.robinhood.ticker.BuildConfig;

import java.io.File;
import java.text.DecimalFormat;

import butterknife.ButterKnife;


public class Global extends Application {

    public static String refreshedToken;
    public static boolean add_user = false;
    public static Context context;
    public static ApplicationComponent applicationComponent;
    public static AppModule appModule;
    private NetComponent mNetComponent;
    private ClsSharedPreference sharedPreference;


    public static final int DEVICE_OS=0;




    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static String BASE_URL = "http://mashhadburse.ir/";







    public static int actionBarHeight;


    public void onCreate() {
        if (Config.DEVELOPER_MODE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
        }
        super.onCreate();
        Global.context = getApplicationContext();
        ButterKnife.setDebug(BuildConfig.DEBUG);

        sharedPreference = new ClsSharedPreference(context);
        appModule=new AppModule(this);
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();

        applicationComponent = DaggerApplicationComponent.builder()
                .netComponent(mNetComponent)
                .applicationModule(new ApplicationModule())
                .build();
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/IRANSANS_BOLD.TTF")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );

//        if (!isMyServiceRunning(ServiceRunAlarmManager.class)) {
//            Intent serviceIntent = new Intent(this, ServiceRunAlarmManager.class);
//            this.startService(serviceIntent);
//        }
    }

   /* public void IntentMain(Context context, int type, int ActionType, String target, String action_uuid, String path) {

        if (type == 1) {
            String file_url = sharedPreference.get_file_url() + path;
            Intent intent = new Intent(context, Act_VideoPlayer.class);
            intent.putExtra("file_name", file_url);
            intent.putExtra("type", 1);
            context.startActivity(intent);

        } else if (type == 0) {

            if (ActionType == 0) {

                if (target.equals("category")) {
                    Intent i1 = new Intent(context, Train_List.class);
                    i1.putExtra("product_uuid", action_uuid);
                    context.startActivity(i1);

                }
                if (target.equals("training")) {
                    if (Act_Main.percent_active){
                        Intent i1 = new Intent(context, Act_Training_Single_Percent.class);
                        i1.putExtra("product_uuid", action_uuid);
                        context.startActivity(i1);
                    }else {
                        Intent i1 = new Intent(context, Act_Training_Single.class);
                        i1.putExtra("product_uuid", action_uuid);
                        context.startActivity(i1);
                    }


                } else if (target.equals("course")) {
                    Intent i1 = new Intent(context, Act_Course_Single.class);
                    i1.putExtra("product_uuid", action_uuid);
                    context.startActivity(i1);
                }
            } else if (ActionType == 1) {

                String url = String.valueOf(action_uuid);

                if (!url.startsWith("www.") && !url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "www." + url;
                }
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);

                ((Activity) context).overridePendingTransition(R.anim.anim_scale_in, R.anim.anim_scale_out);
            } else if (ActionType == 2) {

                Uri uri = Uri.parse("http://instagram.com/_u/" + action_uuid);
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.instagram.android");
                try {
                    context.startActivity(likeIng);
                    ((Activity) context).overridePendingTransition(R.anim.anim_scale_in, R.anim.anim_scale_out);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/" + action_uuid)));
                    ((Activity) context).overridePendingTransition(R.anim.anim_scale_in, R.anim.anim_scale_out);
                }

            } else if (ActionType == 3) {

                String telegram_link = String.valueOf(action_uuid);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Global.BASE_URL_telegram + telegram_link));
                intent.setPackage(Global.Telegram_Package);
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(Global.BASE_URL_telegram + telegram_link)));
                }

                ((Activity) context).overridePendingTransition(R.anim.anim_scale_in, R.anim.anim_scale_out);
            } else if (ActionType == 4) {

                List item = new ArrayList();
                item.add(path);
                Intent intent = new Intent(context, Act_ShowPic_adpter.class);
                intent.putExtra("img_count", 1);
                intent.putExtra("img_position", 1);
                intent.putStringArrayListExtra("img_url", (ArrayList<String>) item);
                context.startActivity(intent);

            } else if (ActionType == 5) {

                Intent i1 = new Intent(context, Act_ShopProductSingle.class);
                i1.putExtra("product_uuid", action_uuid);
                context.startActivity(i1);

            }
        }
    }*/

    public static int getActionBazHeight(Context context) {
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }


    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public ApplicationComponent getGitHubComponent() {
        return applicationComponent;

    }
    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

    public static Context getAppContext() {
        return Global.context;
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "");

        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    public static String getFileSize(long bytes) {

        long logSize = (long) log2(bytes);
        final String[] suffixes = new String[]{" B", " KiB", " MiB", " GiB", " TiB", " PiB", " EiB", " ZiB", " YiB"};

        int suffixIndex = (int) (logSize / 10); // 2^10 = 1024

        double displaySize = bytes / Math.pow(2, suffixIndex * 10);
        DecimalFormat df = new DecimalFormat("#.##");
        String unit = "";
        switch (suffixIndex) {
            case 0:
                unit = "بایت";
                break;
            case 1:
                unit = "کیلوبایت";
                break;
            case 2:
                unit = "مگابایت";
                break;
            case 3:
                unit = "گیگابایت";
                break;
        }
        return df.format(displaySize) + unit;
    }

    public static double log2(long n) {
        // Implement this but without inaccuracies due to FP math.
        // Just count the number of leading zeros and do the math.
        return (Math.log(n) / Math.log(2));
    }


    public static String humanReadableByteCountMg(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %s", bytes / Math.pow(unit, exp), pre);
    }

    public static int converDpToPixel(int dp, Context context) {
        return (int) (TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.getResources().getDisplayMetrics()
        ));
    }


    public static boolean checkEnvoirmentHide() {
        boolean status = false;
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(context, "فضای خالی برای ایجاد فایل ذخیره سازی وجود ندارد", Toast.LENGTH_SHORT).show();
            status = false;
        } else {
            try {

                String dir_video = Environment.getExternalStorageDirectory() + File.separator + ".acapp";
                String dirfinal_video = Environment.getExternalStorageDirectory() + File.separator + ".acapp/.files";

                String dir = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData";
                String dir2 = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData/.acapp";
                String dir_pdf = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData/.acapp/.pfs";
                String dir_voice = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData/.acapp/.vfs";
                String dir_channel = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData/.acapp/.cfs";
                String dirfinal_pdf = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData/.acapp/.pfs/.pfs_vas40";
                String dirfinal_voice = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData/.acapp/.vfs/.vfs_vas40";
                String dirfinal_channel = Environment.getExternalStorageDirectory() + File.separator + ".AndroidData/.acapp/.cfs/.cfs_vas40";


                File folder = new File(dir); //folder name
                File folder2 = new File(dir2); //folder name
                File folder_video = new File(dir_video); //folder name
                File folder_voice = new File(dir_voice); //folder name
                File folder_pdf = new File(dir_pdf); //folder name
                File folder_channel = new File(dir_channel); //folder name
                File final_video = new File(dirfinal_video); //folder name
                File final_voice = new File(dirfinal_voice); //folder name
                File final_pdf = new File(dirfinal_pdf); //folder name
                File final_channel = new File(dirfinal_channel); //folder name


                if (!folder.exists())
                    folder.mkdirs();
                if (!folder2.exists())
                    folder2.mkdirs();

                if (!folder_video.exists())
                    folder_video.mkdirs();
                if (!final_video.exists())
                    final_video.mkdirs();

                if (!folder_voice.exists())
                    folder_voice.mkdirs();
                if (!folder_pdf.exists())
                    folder_pdf.mkdirs();
                if (!folder_channel.exists())
                    folder_channel.mkdirs();

                if (!final_voice.exists()) {
                    for (int i = 0; i < 40; i++) {
                        File folderalot = new File(dir_voice + "/.vfs_vas" + i);
                        folderalot.mkdirs();
                    }
                }
                if (!final_pdf.exists()) {
                    for (int i = 0; i < 40; i++) {
                        File folderalot = new File(dir_pdf + "/.pfs_vas" + i);
                        folderalot.mkdirs();
                    }
                }
                if (!final_channel.exists()) {
                    for (int i = 0; i < 40; i++) {
                        File folderalot = new File(dir_channel + "/.cfs_vas" + i);
                        folderalot.mkdirs();
                    }
                }
                status = true;
            } catch (Exception e) {
            }
        }
        return status;
    }


    public static String namefileEncrtput(String filename) {
        String name = null;
        int lstchr = filename.lastIndexOf("/");
        String chnamefile = filename.substring(lstchr + 1);
        String notype = null;
        if (chnamefile.contains(".")) {
            notype = chnamefile.substring(0, chnamefile.lastIndexOf('.'));
        }
        name = new StringBuilder(notype).reverse().toString();
        return name + ".vb";
    }

   /* public static String namefileEncrtput(String filename) {
        String name = null;
        int lstchr = filename.lastIndexOf("/");
        String chnamefile = filename.substring(lstchr + 1);
        String notype = null;
        if (chnamefile.contains(".")) {
            notype = chnamefile.substring(0, chnamefile.lastIndexOf('.'));
        }
        name = new StringBuilder(notype).reverse().toString();
        return name + ".mp4";
    }

    public static String namefileEncrtput(String filename) {
        String name = null;
        int lstchr = filename.lastIndexOf("/");
        String chnamefile = filename.substring(lstchr + 1);
        String notype = null;
        if (chnamefile.contains(".")) {
            notype = chnamefile.substring(0, chnamefile.lastIndexOf('.'));
        }
        name = new StringBuilder(notype).reverse().toString();
        return name + ".mp3";
    }*/

    public static String namefileEncrtput_video(String filename) {
        String name = null;
        int lstchr = filename.lastIndexOf("/");
        String chnamefile = filename.substring(lstchr + 1);
        String notype = null;
        if (chnamefile.contains(".")) {
            notype = chnamefile.substring(0, chnamefile.lastIndexOf('.'));
        }
        name = new StringBuilder(notype).reverse().toString();
        return name + ".mp4";
    }

    public static boolean NetworkConnection() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }
        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }
        return false;
    }


    public static class RtlGridLayoutManager extends GridLayoutManager {

        public RtlGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        public RtlGridLayoutManager(Context context, int spanCount) {
            super(context, spanCount);
        }

        public RtlGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
            super(context, spanCount, orientation, reverseLayout);
        }

        @Override
        protected boolean isLayoutRTL() {
            return true;
        }
    }

    public static int getSizeScreen(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }


    public static int getSizeScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return height;
    }
}
