package com.example.karayek.ui.fierbase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.karayek.R;
import com.example.karayek.ui.splashScreen.SplashScreen;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FirebaseMessage extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0){

            showNotfication(remoteMessage.getData().get("title"),remoteMessage.getData().get("message"));

        }
        if (remoteMessage.getNotification() != null){

            showNotfication(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }

    }
    private RemoteViews getCustomDesign(String title,String message){

        RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(), R.layout.firebase_message_recive);
remoteViews.setTextViewText(R.id.txt_title_firbase,title);
remoteViews.setTextViewText(R.id.txt_title_firbase,message);
remoteViews.setImageViewResource(R.id.img_logo_firebase_message,R.drawable.ic_icon_headers);

        return remoteViews;

    }
    public void showNotfication(String title,String message){
        Intent intent = new Intent(this, SplashScreen.class);
        String channel_id = "web_app_content";
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),channel_id)
                .setSmallIcon(R.drawable.ic_icon_headers)
                .setSound(uri)
                .setAutoCancel(true)
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){

            builder = builder.setContent(getCustomDesign(title,message));
        }
        else {

            builder = builder.setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(R.drawable.ic_icon_headers);

        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(channel_id,"KaraYek",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setSound(uri,null);
            notificationManager.createNotificationChannel(notificationChannel);

        }
        notificationManager.notify(0,builder.build());

    }
}
