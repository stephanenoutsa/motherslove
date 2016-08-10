package com.babyandi.stephnoutsa.babyandi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyHivReceiver extends BroadcastReceiver {

    AlarmStart alarmStart = new AlarmStart();

    public MyHivReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Start service
        Intent service = new Intent(context, MyHivService.class);
        context.startService(service);

        //Schedule next alarm
        alarmStart.startHivAlarm(context);
    }
}
