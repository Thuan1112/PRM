package com.example.se1413_day06_dynamicui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout linerLayout = new LinearLayout(this);
        linerLayout.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(this);
        title.setText("Test creating dynamic UI");
        title.setLayoutParams(params);

        TextView titleID = new TextView(this);
        titleID.setText("ID: ");
        titleID.setLayoutParams(params);

        EditText edtID = new EditText(this);
        edtID.setId(R.id.productID);
        edtID.setLayoutParams(params);

        TextView titleName = new TextView(this);
        titleName.setText("Name: ");
        titleName.setLayoutParams(params);

        EditText edtName = new EditText(this);
        edtName.setId(R.id.productName);
        edtName.setLayoutParams(params);

        TextView titlePrice = new TextView(this);
        titlePrice.setText("Price: ");
        titlePrice.setLayoutParams(params);

        EditText edtPrice = new EditText(this);
        edtPrice.setId(R.id.productPrice);
        edtPrice.setLayoutParams(params);

        Button btnCreate = new Button(this);
        btnCreate.setText("Create product");
        btnCreate.setLayoutParams(params);

        linerLayout.addView(title);
        linerLayout.addView(titleID);
        linerLayout.addView(edtID);
        linerLayout.addView(titleName);
        linerLayout.addView(edtName);
        linerLayout.addView(titlePrice);
        linerLayout.addView(edtPrice);
        linerLayout.addView(btnCreate);

        addContentView(linerLayout, params);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtID = findViewById(R.id.productID);
                EditText edtName = findViewById(R.id.productName);
                EditText edtPrice = findViewById(R.id.productPrice);
                String result = "ID: " + edtID.getText().toString() +
                        " - Name: " + edtName.getText().toString() +
                        " - Price: " + edtPrice.getText().toString();
                Toast.makeText(CreateActivity.this, result, Toast.LENGTH_SHORT).show();
                Intent intent = CreateActivity.this.getIntent();
                intent.putExtra("result", result);
                CreateActivity.this.setResult(RESULT_OK,intent);
                CreateActivity.this.finish();
            }
        });
    }
}