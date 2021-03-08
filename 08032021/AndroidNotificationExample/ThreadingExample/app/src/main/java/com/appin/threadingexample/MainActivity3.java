package com.appin.threadingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
Button button,button2;
    private NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button=findViewById(R.id.button4);
        button2=findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotification();
            }
        });
        this.notificationManagerCompat = NotificationManagerCompat.from(this);
    }
    public void sendNotification() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.journaldev.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_1_ID)
        .setSmallIcon(android.R.drawable.ic_dialog_alert).setContentIntent(pendingIntent)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
        .setContentTitle("Notifications Title")
        .setContentText("Your notification content here.")
        .setSubText("Tap to view the website.").build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Will display the notification in the notification bar
        notificationManager.notify(1, notification);
    }

    public void cancelNotification() {

        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
        nMgr.cancel(1);
    }
}