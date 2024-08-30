package com.example.dbhandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            String status = isAirplaneModeOn ? "ON" : "OFF";
            Toast.makeText(context, "Airplane Mode is " + status, Toast.LENGTH_SHORT).show();
        }
    }
}