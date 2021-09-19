package com.example.se1413_day04_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToAdd(View view) {
       EditText edtNum1 = findViewById(R.id.edtNum);
       EditText edtNum2 = findViewById(R.id.edtNum2);
       TextView txtResult = findViewById(R.id.txtResult);
        int number1 = Integer.parseInt(edtNum1.getText().toString());
        int number2 = Integer.parseInt(edtNum2.getText().toString());
        int result = number1 + number2;
        txtResult.setText("Result = " + result);
    }
}