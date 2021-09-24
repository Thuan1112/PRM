package com.example.se1413_day06_dynamicui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
    }

    public void clickToCreate(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        /*startActivity(intent);*/
        startActivityForResult(intent, 6780);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 6780){
            if(requestCode == RESULT_OK){
                txtResult.setText(data.getStringExtra("result"));
            }
        }
    }
}