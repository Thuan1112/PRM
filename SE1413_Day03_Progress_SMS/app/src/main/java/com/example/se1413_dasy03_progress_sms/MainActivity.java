package com.example.se1413_dasy03_progress_sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnProgress;
    private ProgressDialog mypro_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProgress = findViewById(R.id.btnProgress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mypro_bar = new ProgressDialog(MainActivity.this);
                mypro_bar.setMessage("Loading.....");
                mypro_bar.setTitle("Please wait...");
                mypro_bar.setProgressStyle(mypro_bar.STYLE_HORIZONTAL);
                mypro_bar.setProgress(0);
                mypro_bar.setMax(20);
                mypro_bar.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (mypro_bar.getProgress() < mypro_bar.getMax()){
                                Thread.sleep(1000);// code
                                handler.sendMessage(handler.obtainMessage());
                            }
                            if (mypro_bar.getProgress() >= mypro_bar.getMax() ){
                                mypro_bar.dismiss();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            Handler handler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    mypro_bar.incrementProgressBy( 2);
                }
            };
        });
    }

    public void clickToCallSMS(View view) {
        Intent intent = new Intent(this,CreateSMSActivity.class);
        startActivity(intent);
    }
}