package com.example.se1413_dasy03_progress_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateSMSActivity extends AppCompatActivity {

    private EditText editPhone, editContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_smsactivity);
        editPhone = findViewById(R.id.editPhone);
        editContent = findViewById(R.id.editContent);
    }

        public void clickToSend(View view) {
            String phone = editPhone.getText().toString();
            String content = editContent.getText().toString();
            SmsManager smsManager = SmsManager.getDefault();
            Intent intent = new Intent( "ThuanNL_Send_SMS");
            PendingIntent pending = PendingIntent.getBroadcast( this, 0, intent, 0);
            registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    int result = getResultCode();
                    String mess = "Send OK";
                    if (result != Activity.RESULT_OK){
                        mess = "Send Fail";
                    }
                    Toast.makeText(CreateSMSActivity.this, mess, Toast.LENGTH_LONG).show();
                }
            }, new IntentFilter("ThuanNL_Send_SMS"));
            smsManager.sendTextMessage(phone, null, content, pending, null);
            finish();
        }
}