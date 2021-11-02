package com.example.se1413_day08_notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskInfo;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager manager;
    private int notiID = 6789;
    private int numMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSend(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("New Message");
        builder.setContentText("Notification DEMO");
        builder.setSmallIcon(R.drawable.ic_action_unread);
        builder.setNumber(++numMess);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("info","SE1413");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(notiID, builder.build());
    }

    public void clickToCancel(View view) {
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(notiID);
    }

    public void clickToMultiple(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("LV UP");
        builder.setContentText("Notification DEMO");
        builder.setSmallIcon(R.drawable.ic_action_unread);
        builder.setNumber(++numMess);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = {"HP","MP+","Luck+"};
        for (int i = 0;i < events.length; i++){
            inboxStyle.addLine(events[i]);
        }

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("info","SE1413");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(notiID, builder.build());
    }
}