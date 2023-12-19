package com.example.vivrelefrance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Air_Plane extends BroadcastReceiver {
    boolean isAirplaneModeEnabled;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
             isAirplaneModeEnabled = intent.getBooleanExtra("state", false);

            if (isAirplaneModeEnabled) {
                // Airplane mode is enabled
                Toast.makeText(context, "Airplane mode is ON,offline only!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
