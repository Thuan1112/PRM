package com.example.se1413_day04_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    private Button btnSub;
    private EditText edtNum1, edtNum2;
    private TextView txtResult;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_2, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        edtNum1 = getActivity().findViewById(R.id.edtNum);
        edtNum2 = getActivity().findViewById(R.id.edtNum2);
        txtResult = getActivity().findViewById(R.id.txtResult);
        btnSub = getActivity().findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(edtNum1.getText().toString());
                int number2 = Integer.parseInt(edtNum2.getText().toString());
                int result = number1 - number2;
                txtResult.setText("Result = " + result);
            }
        });
    }

/*
    public void clickToAdd(View view) {
        edtNum1 = getActivity().findViewById(R.id.edtNum);
        edtNum2 = getActivity().findViewById(R.id.edtNum2);
        txtResult = getActivity().findViewById(R.id.txtResult);
        int number1 = Integer.parseInt(edtNum1.getText().toString());
        int number2 = Integer.parseInt(edtNum2.getText().toString());
        int result = number1 + number2;
        txtResult.setText("Result = " + result);
    }*/
}
