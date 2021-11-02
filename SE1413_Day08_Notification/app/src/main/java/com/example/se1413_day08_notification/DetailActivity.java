package com.example.se1413_day08_notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtResult = findViewById(R.id.txtResult);
        Intent intent = this.getIntent();
        String result = intent.getStringExtra("info");
        txtResult.setText(result);
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(6789);
    }
}