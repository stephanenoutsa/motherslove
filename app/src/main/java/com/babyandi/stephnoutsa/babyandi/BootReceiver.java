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

public class BootReceiver extends BroadcastReceiver {

    NotificationCompat.Builder notification;
    Notification notif;
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    SimpleDateFormat sdf;
    String ndate, lmp;
    Date notifDate, lmpDate;
    Date today;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            final MyDBHandler dbHandler = new MyDBHandler(context, null, null, 1);
            final Context cont = context;

            // Get last notification date from database
            ndate = dbHandler.getLastNotifDay();
            String expectedPattern = "MMM d, yyyy";
            sdf = new SimpleDateFormat(expectedPattern);

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        notifDate = sdf.parse(ndate);
                        today = new Date();
                        long diffInMs = today.getTime() - notifDate.getTime();
                        int diff = (int) diffInMs / (1000 * 60 * 60);

                        // Check for notification if last notification was more than 24 hours ago
                        if(diff >= 24) {
                            lmpDate = sdf.parse(lmp);
                            long diffInMillis = today.getTime() - lmpDate.getTime();
                            long difference = diffInMillis / (1000 * 60 * 60 * 24 * 7);
                            if (difference < 1) {
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
                            } else if (difference < 2) {
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
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread stephThread = new Thread(r);
            stephThread.start();

            AlarmStart alarmStart = new AlarmStart();
            alarmStart.startAlarm(context);
        }
    }
}
