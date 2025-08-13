package com.example.augustandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirPlanceModeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            if (isAirplaneModeOn(context.getApplicationContext()))
            {
                Toast.makeText(context, "Airplane Mode On", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Airplane Mode Off", Toast.LENGTH_SHORT).show();
            }
    }
    public static boolean isAirplaneModeOn(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
