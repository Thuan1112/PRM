package com.example.se1413_day05_spinner_date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView txtBirthday;
    private Spinner spNationality;
    private String selectedSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBirthday = findViewById(R.id.txtBirthDay);
        spNationality = findViewById(R.id.spNationality);
        List<String> dataSrc = new ArrayList<>();
        dataSrc.add("Ít người");
        dataSrc.add("Kinh");
        dataSrc.add("Nước ngoài");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataSrc);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNationality.setAdapter(dataAdapter);
        spNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    selectedSP = spNationality.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void clickToChangeDate(View view) {
        DialogFragment dateFragment = new com.example.se1413_day05_spinner_date.DatePickerDialog();
        dateFragment.show(getSupportFragmentManager(), "DatePicker");
    }

    public void clickToRegister(View view) {
        Intent intent = new Intent(this, ShowActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("birthday", txtBirthday.getText().toString());
        bundle.putString("nationality", selectedSP);
        intent.putExtra("INFO", bundle);
        startActivity(intent);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
    }
}