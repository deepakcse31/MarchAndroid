package com.example.marchandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirPlaneModeChangeListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (isAirplaneModeEnabled(context))
        {
            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAirplaneModeEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
