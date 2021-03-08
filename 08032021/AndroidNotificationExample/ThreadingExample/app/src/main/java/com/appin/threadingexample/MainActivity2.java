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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    private NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });

        this.notificationManagerCompat = NotificationManagerCompat.from(this);
    }
    private void addNotification() {
        Intent notificationIntent = new Intent(this, NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", "This is a notification message");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.messageicon) //set icon for notification
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.messageicon2))
                        .setContentTitle("Notifications Example") //set title of notification
                        .setContentText("This is a notification message")//this is notification message
                        .setAutoCancel(true) // makes auto cancel of notification
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .build(); //set priority of notification

// Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification);
    }
    
}