package com.babyandi.stephnoutsa.babyandi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyImmunizationReceiver extends BroadcastReceiver {

    AlarmStart alarmStart = new AlarmStart();

    public MyImmunizationReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Start service
        Intent service = new Intent(context, MyImmunizationService.class);
        context.startService(service);

        //Schedule next alarm
        alarmStart.startImmAlarm(context);
    }
}
