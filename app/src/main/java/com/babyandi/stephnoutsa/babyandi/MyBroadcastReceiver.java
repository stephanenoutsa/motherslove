package com.babyandi.stephnoutsa.babyandi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    AlarmStart alarmStart = new AlarmStart();

    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Start service
        Intent service = new Intent(context, MyService.class);
        context.startService(service);

        //Schedule next alarm
        alarmStart.startAlarm(context);
    }
}
