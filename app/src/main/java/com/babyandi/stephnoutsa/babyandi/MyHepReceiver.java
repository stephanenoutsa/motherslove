package com.babyandi.stephnoutsa.babyandi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyHepReceiver extends BroadcastReceiver {

    AlarmStart alarmStart = new AlarmStart();

    public MyHepReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Start service
        Intent service = new Intent(context, MyHepService.class);
        context.startService(service);

        //Schedule next alarm
        alarmStart.startHepAlarm(context);
    }
}
