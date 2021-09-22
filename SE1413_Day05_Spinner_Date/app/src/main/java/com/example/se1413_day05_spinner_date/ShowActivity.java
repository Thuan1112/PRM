package com.example.se1413_day05_spinner_date;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    private TextView txtBirthday, txtNationality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        txtBirthday =  findViewById(R.id.txtBirthDay);
        txtNationality = findViewById(R.id.txtNationality);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("INFO");
        txtBirthday.setText("Birthday " + bundle.getString("birthday"));
        txtNationality.setText("Nationality" + bundle.getString("nationality"));
    }
}