package com.babyandi.stephnoutsa.babyandi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            MyDBHandler dbHandler = new MyDBHandler(context, null, null, 1);
            AlarmStart alarmStart = new AlarmStart();
            if (!dbHandler.getLMP().equals("null")) {
                alarmStart.instantCheck(context);
            }
            if (!dbHandler.getDOB().getDday().equals("null")) {
                alarmStart.instantImmCheck(context);
            }
            String hiv = dbHandler.getHivStatus();
            String hepatitis = dbHandler.getHepatitisStatus();
            if(hiv.equals("positive")) {
                alarmStart.instantHivCheck(context);
            }
            if(hepatitis.equals("positive")) {
                alarmStart.instantHepCheck(context);
            }
        }
    }
}