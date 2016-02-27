package com.babyandi.stephnoutsa.babyandi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class MyService extends Service {
    NotificationCompat.Builder notification;
    Notification notif;
    SimpleDateFormat sdf;
    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    String lmp;
    Date lmpDate;
    Date today;
    Context context = this;
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    //String text = getString(R.string.app_name); // Example of how to use a string resource from .java file

    public MyService() {
    }

    @Override
    public void onCreate() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.i(TAG, "onStartCommand method called");

        lmp = dbHandler.getLMP();
        String expectedPattern = "MMM d, yyyy";
        sdf = new SimpleDateFormat(expectedPattern);

        notification = new NotificationCompat.Builder(this);
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
                        // Build the notification
                        notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                        notification.setTicker(getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(getString(R.string.notification_title));
                        notification.setContentText(getString(R.string.notification_1_text));
                        notification.setSound(alarmSound);

                        Intent i = new Intent(context, Notifications.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                        notification.setContentIntent(pendingIntent);

                        // Builds a notification and issues it
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Random r = new Random();
                        int rand = r.nextInt(1000);
                        nm.notify(rand, notification.build());

                        // Add the notification to the database
                        DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                        String nday = f.format(new Date().getTime());
                        String nmessage = getString(R.string.notification_1_text);
                        notif = new Notification(nday, nmessage);
                        dbHandler.addNotification(notif);
                    } else if (diff < 2) {
                        // Build the notification
                        notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                        notification.setTicker(getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(getString(R.string.notification_title));
                        notification.setContentText(getString(R.string.notification_1_text));
                        notification.setSound(alarmSound);

                        Intent i = new Intent(context, Notifications.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                        notification.setContentIntent(pendingIntent);

                        // Builds a notification and issues it
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Random r = new Random();
                        int rand = r.nextInt(1000);
                        nm.notify(rand, notification.build());

                        // Add the notification to the database
                        DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                        String nday = f.format(new Date().getTime());
                        String nmessage = getString(R.string.notification_1_text);
                        notif = new Notification(nday, nmessage);
                        dbHandler.addNotification(notif);
                    } else {
                        // Build the notification
                        notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                        notification.setTicker(getString(R.string.notification_ticker)); // Sets the text displayed when notification is received
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(getString(R.string.notification_title));
                        notification.setContentText(getString(R.string.notification_1_text));
                        notification.setSound(alarmSound);

                        Intent i = new Intent(context, Notifications.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                        notification.setContentIntent(pendingIntent);

                        // Builds a notification and issues it
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Random r = new Random();
                        int rand = r.nextInt(1000);
                        nm.notify(rand, notification.build());

                        // Add the notification to the database
                        DateFormat f = new SimpleDateFormat("MMM d, yyyy");
                        String nday = f.format(new Date().getTime());
                        String nmessage = getString(R.string.notification_1_text);
                        notif = new Notification(nday, nmessage);
                        dbHandler.addNotification(notif);
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // This is executed if lmp does not match expected pattern
                }
                //Log.i(TAG, "Your LMP is " + lmp +".");
            }
        };

        Thread stephThread = new Thread(r);
        stephThread.start();

        return START_STICKY; // START_STICKY means service restarts even if Android OS (for example) destroys it.

    }

    @Override
    public void onDestroy() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
