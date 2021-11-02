package com.example.se1413_day02_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  static final int CREATE_CODE = 6789;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        Intent intent = this.getIntent();
        String result = intent.getStringExtra("INFO");
        if(result != null){
            txtResult.setText(result);
        }else txtResult.setText("");
    }

    public void clickToCreate(View view) {
        Intent intent = new Intent(this,CreateProductActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, CREATE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CREATE_CODE){
            if (resultCode == RESULT_OK){
                txtResult.setText(data.getStringExtra( "INFO"));
            }
        }
    }
}