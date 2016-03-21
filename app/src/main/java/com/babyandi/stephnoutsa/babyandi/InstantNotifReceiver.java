package com.babyandi.stephnoutsa.babyandi;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InstantNotifReceiver extends BroadcastReceiver {

    NotificationCompat.Builder notification;
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    Notification notif;

    public InstantNotifReceiver() {
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        final MyDBHandler dbHandler = new MyDBHandler(context, null, null, 1);
        final Context cont = context;
        String dbDate = dbHandler.getEDD();
        final String notifText = cont.getString(R.string.first_notification_1) + dbDate + "\n" +
                cont.getString(R.string.first_notification_2);
        //Toast.makeText(cont, notifText, Toast.LENGTH_LONG).show();

        notification = new NotificationCompat.Builder(cont);
        notification.setAutoCancel(true); // Delete notification from screen after user has viewed it.

        Runnable r = new Runnable() {
            @Override
            public void run() {
                notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                notification.setTicker(cont.getString(R.string.first_notification_ticker)); // Sets the text displayed when notification is received
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle(cont.getString(R.string.notification_title));
                notification.setContentText(notifText);
                notification.setSound(alarmSound);

                Intent i = new Intent(cont, Notifications.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(cont, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                // Builds a notification and issues it
                NotificationManager nm = (NotificationManager) cont.getSystemService(cont.NOTIFICATION_SERVICE);
                Random r = new Random();
                int rand = r.nextInt(1000);
                nm.notify(rand, notification.build());

                // Add the notification to the database
                DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                String nday = f.format(new Date().getTime());
                String nmessage = cont.getString(R.string.notification_1_text_hiv);
                notif = new Notification(nday, nmessage);
            }
        };

        Thread stephThread = new Thread(r);
        stephThread.start();

    }
}
