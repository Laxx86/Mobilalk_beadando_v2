package com.example.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Notif {
    private static final String CHANNEL_ID = "notif_channel";

    private Context mContext;
    private NotificationManager nManager;

    public Notif (Context context) {
        this.nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        this.mContext = context;
        createChannel();


    }

    private void createChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return;
        }

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "bookingapp_notif",
                 NotificationManager.IMPORTANCE_DEFAULT);

        channel.enableVibration(true);
        channel.enableLights(true);
        channel.setDescription("It is time to book Notification from Nail booking app");
        this.nManager.createNotificationChannel(channel);

    }

    public void send(String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, CHANNEL_ID).setContentTitle("BookinApp")
                .setContentText(message).setSmallIcon(R.drawable.ic_baseline_calendar_month_24);

        this.nManager.notify(1, builder.build());
    }


}
