package com.example.smsreceiver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int p =0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECEIVE_SMS)){

            }
            else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},p);
            }
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String address = extras.getString("MessageNumber");
            String message = extras.getString("Message");

            TextView addressField = findViewById(R.id.address);
            TextView messageField = findViewById(R.id.message);

            addressField.setText("Message From : " +address);
            messageField.setText("Messsage : "+message);
        }

    }
}
