package com.example.smsreceiver;
import android.content.BroadcastReceiver;
import android.content.*;
import android.os.Bundle;
import android.telephony.*;
import android.widget.Toast;

public class SimpleSmsReciever extends BroadcastReceiver {

    private static final String TAG = "Message recieved";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle pudsBundle = intent.getExtras();
        Object[] pdus = (Object[]) pudsBundle.get("pdus");
        SmsMessage messages = SmsMessage.createFromPdu((byte[]) pdus[0]);

        // Start Application's  MainActivty activity

        if ( messages.getOriginatingAddress()=="OrangeMoney"){
            Intent smsIntent = new Intent(context,MainActivity.class);

            smsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


            smsIntent.putExtra("MessageNumber", messages.getOriginatingAddress());

            smsIntent.putExtra("Message", messages.getMessageBody());

            context.startActivity(smsIntent);

            // Get the Sender Message : messages.getMessageBody()
            // Get the SenderNumber : messages.getOriginatingAddress()

            Toast.makeText(context, "SMS Received From :"+messages.getOriginatingAddress()+"\n"+ messages.getMessageBody(), Toast.LENGTH_LONG).show();
        }




    }
}
