package com.babyandi.stephnoutsa.babyandi;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyBroadcastReceiver extends BroadcastReceiver {

    AlarmStart alarmStart = new AlarmStart();
    NotificationCompat.Builder notification;
    Notification notif;
    SimpleDateFormat sdf;
    String lmp;
    Date lmpDate;
    Date today;
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final MyDBHandler dbHandler = new MyDBHandler(context, null, null, 1);
        final Context cont = context;

        // Start service
        /*Intent service = new Intent(context, MyService.class);
        context.startService(service);*/

        // Check which notification to display, if any
        lmp = dbHandler.getLMP();
        String expectedPattern = "MMM d, yyyy";
        sdf = new SimpleDateFormat(expectedPattern);

        notification = new NotificationCompat.Builder(cont);
        notification.setAutoCancel(true); // Delete notification from screen after user has viewed it.

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    lmpDate = sdf.parse(lmp);
                    today = new Date();
                    long diffInMs = today.getTime() - lmpDate.getTime();
                    long diff = diffInMs / (1000 * 60 * 60 * 24 * 7);
                    if (diff < 1) {
                        // Build the notification for the regular ANC visit
                        notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                        notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(cont.getString(R.string.notification_title));
                        notification.setContentText(cont.getString(R.string.notification_1_text));
                        notification.setSound(alarmSound);

                        Intent i = new Intent(cont, Notifications.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(cont, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                        notification.setContentIntent(pendingIntent);

                        // Builds a notification and issues it
                        NotificationManager nm = (NotificationManager) cont.getSystemService(cont.NOTIFICATION_SERVICE);
                        Random r = new Random();
                        int rand = r.nextInt(1000);
                        nm.notify(rand, notification.build());

                        // Handles notifications for users with special needs
                        if(dbHandler.getHepatitisStatus() == "positive") {
                            // Build the notification for users hepatitis
                            notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                            notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentTitle(cont.getString(R.string.notification_title));
                            notification.setContentText(cont.getString(R.string.notification_1_text_hepatitis));
                            notification.setSound(alarmSound);

                            notification.setContentIntent(pendingIntent);

                            // Builds a notification and issues it
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notification_1_text_hepatitis);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);
                        }
                        if(dbHandler.getHivStatus() == "positive") {
                            // Build the notification for users hepatitis
                            notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                            notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentTitle(cont.getString(R.string.notification_title));
                            notification.setContentText(cont.getString(R.string.notification_1_text_hiv));
                            notification.setSound(alarmSound);

                            notification.setContentIntent(pendingIntent);

                            // Builds a notification and issues it
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notification_1_text_hiv);
                            notif = new Notification(nday, nmessage);
                        }

                        // Add the notification to the database
                        DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                        String nday = f.format(new Date().getTime());
                        String nmessage = cont.getString(R.string.notification_1_text);
                        notif = new Notification(nday, nmessage);
                        dbHandler.addNotification(notif);
                    } else if (diff < 2) {
                        // Build the notification for the regular ANC visit
                        notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                        notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(cont.getString(R.string.notification_title));
                        notification.setContentText(cont.getString(R.string.notification_1_text));
                        notification.setSound(alarmSound);

                        Intent i = new Intent(cont, Notifications.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(cont, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                        notification.setContentIntent(pendingIntent);

                        // Builds a notification and issues it
                        NotificationManager nm = (NotificationManager) cont.getSystemService(cont.NOTIFICATION_SERVICE);
                        Random r = new Random();
                        int rand = r.nextInt(1000);
                        nm.notify(rand, notification.build());

                        // Handles notifications for users with special needs
                        if(dbHandler.getHepatitisStatus() == "positive") {
                            // Build the notification for users hepatitis
                            notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                            notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentTitle(cont.getString(R.string.notification_title));
                            notification.setContentText(cont.getString(R.string.notification_1_text_hepatitis));
                            notification.setSound(alarmSound);

                            notification.setContentIntent(pendingIntent);

                            // Builds a notification and issues it
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notification_1_text_hepatitis);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);
                        }
                        if(dbHandler.getHivStatus() == "positive") {
                            // Build the notification for users hepatitis
                            notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                            notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentTitle(cont.getString(R.string.notification_title));
                            notification.setContentText(cont.getString(R.string.notification_1_text_hiv));
                            notification.setSound(alarmSound);

                            notification.setContentIntent(pendingIntent);

                            // Builds a notification and issues it
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notification_1_text_hiv);
                            notif = new Notification(nday, nmessage);
                        }

                        // Add the notification to the database
                        DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                        String nday = f.format(new Date().getTime());
                        String nmessage = cont.getString(R.string.notification_1_text);
                        notif = new Notification(nday, nmessage);
                        dbHandler.addNotification(notif);
                    } else {
                        // Build the notification for the regular ANC visit
                        notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                        notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(cont.getString(R.string.notification_title));
                        notification.setContentText(cont.getString(R.string.notification_1_text));
                        notification.setSound(alarmSound);

                        Intent i = new Intent(cont, Notifications.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(cont, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                        notification.setContentIntent(pendingIntent);

                        // Builds a notification and issues it
                        NotificationManager nm = (NotificationManager) cont.getSystemService(cont.NOTIFICATION_SERVICE);
                        Random r = new Random();
                        int rand = r.nextInt(1000);
                        nm.notify(rand, notification.build());

                        // Handles notifications for users with special needs
                        if(dbHandler.getHepatitisStatus() == "positive") {
                            // Build the notification for users hepatitis
                            notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                            notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentTitle(cont.getString(R.string.notification_title));
                            notification.setContentText(cont.getString(R.string.notification_1_text_hepatitis));
                            notification.setSound(alarmSound);

                            notification.setContentIntent(pendingIntent);

                            // Builds a notification and issues it
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notification_1_text_hepatitis);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);
                        }
                        if(dbHandler.getHivStatus() == "positive") {
                            // Build the notification for users hepatitis
                            notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                            notification.setTicker(cont.getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentTitle(cont.getString(R.string.notification_title));
                            notification.setContentText(cont.getString(R.string.notification_1_text_hiv));
                            notification.setSound(alarmSound);

                            notification.setContentIntent(pendingIntent);

                            // Builds a notification and issues it
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notification_1_text_hiv);
                            notif = new Notification(nday, nmessage);
                        }

                        // Add the notification to the database
                        DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                        String nday = f.format(new Date().getTime());
                        String nmessage = cont.getString(R.string.notification_1_text);
                        notif = new Notification(nday, nmessage);
                        dbHandler.addNotification(notif);
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // This is executed if lmp does not match expected pattern
                }
            }
        };

        Thread stephThread = new Thread(r);
        stephThread.start();

        //Schedule next alarm
        alarmStart.startAlarm(context);
    }
}
