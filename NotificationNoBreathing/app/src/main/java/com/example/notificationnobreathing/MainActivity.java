package com.example.notificationnobreathing;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isNetwork();
        noNetwork();
    }

    private void isNetwork(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(android.R.drawable.ic_media_play);

        builder.setContentTitle("VERY NICE!");
        builder.setContentText("ur network is connected");

        Intent notificationIntent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int)System.currentTimeMillis(), notificationIntent, 0);

        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
              style.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.verynice)).build();

        builder.setStyle(style);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }

    private void noNetwork(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setSmallIcon(android.R.drawable.ic_media_play);

        builder.setContentTitle("OH NOOOOO!!");
        builder.setContentText("ur network sucks ass");

        Intent notificationIntent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, (int)System.currentTimeMillis(), notificationIntent, 0);

        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.noconnectivity)).build();

        builder.setStyle(style);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);

    }
}
