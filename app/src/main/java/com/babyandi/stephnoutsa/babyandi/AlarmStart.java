package com.babyandi.stephnoutsa.babyandi;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

public class AlarmStart {

    public AlarmStart() {
    }

    public void startAlarm(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    pendingIntent);
        }
    }

    public void instantNotif(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, InstantNotifReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, InstantNotifReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    pendingIntent);
        }
    }

    public void instantCheck(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    pendingIntent);
        }
    }

    // For Hiv
    public void startHivAlarm(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyHivReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyHivReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    pendingIntent);
        }
    }

    public void instantHivCheck(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyHivReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyHivReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    pendingIntent);
        }
    }

    // For Hepatitis
    public void startHepAlarm(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    pendingIntent);
        }
    }

    public void instantHepCheck(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    pendingIntent);
        }
    }

    // For immunization
    public void startImmAlarm(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 60 * 60 * 24),
                    pendingIntent);
        }
    }

    public void instantImmCheck(Context context) {
        if(Build.VERSION.SDK_INT < 19) {
            //Toast.makeText(context, "os.Build < 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    //AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
        else {
            //Toast.makeText(context, "os.Build >= 19", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(context, MyImmunizationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + (1000 * 2),
                    pendingIntent);
        }
    }

}
