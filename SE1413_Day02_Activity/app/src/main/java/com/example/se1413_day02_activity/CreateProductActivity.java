package com.example.se1413_day02_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateProductActivity extends AppCompatActivity {

    private EditText editID, editName, editPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        editID    = findViewById(R.id.editID);
        editName  = findViewById(R.id.editName);
        editPrice = findViewById(R.id.editPrice);
    }

    public void clickToDone(View view) {
        String id = editID.getText().toString();
        String name = editName.getText().toString();
        String price = editPrice.getText().toString();
        String result = "ID: " + id + " - Name: " + name + " - Price: " + price;
//        Intent intent = new Intent(this,MainActivity.class);
//        intent.putExtra("INFO", result);
//        startActivity(intent);
        Intent intent = this.getIntent();
        intent.putExtra( "INFO", result);
        this.setResult(RESULT_OK, intent);
        finish();
    }
}