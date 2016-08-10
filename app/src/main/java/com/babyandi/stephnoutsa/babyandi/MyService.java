package com.babyandi.stephnoutsa.babyandi;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyService extends Service {

    NotificationCompat.Builder notification;
    Notification notif;
    SimpleDateFormat sdf;
    Date lmpDate;
    Date today;
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    Context context = this;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final MyDBHandler dbHandler = new MyDBHandler(context, null, null, 1);
        final Context cont = context;

        notification = new NotificationCompat.Builder(cont);
        notification.setAutoCancel(true); // Delete notification from screen after user has viewed it.

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                try {
                    String ticker;

                    // Get the received number from database
                    int received = dbHandler.getReceived();

                    // Check which notification to display, if any
                    String lmp = dbHandler.getLMP();
                    String expectedPattern = "dd/MM/yyyy";
                    sdf = new SimpleDateFormat(expectedPattern);

                    lmpDate = sdf.parse(lmp);
                    today = new Date();
                    long diffInMs = today.getTime() - lmpDate.getTime();
                    long diff =  diffInMs / (1000 * 60 * 60 * 24);

                    // Build the notification for the regular ANC visit
                    notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                    notification.setContentTitle(cont.getString(R.string.notification_title));
                    notification.setSound(alarmSound);
                    Intent i = new Intent(cont, Notifications.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(cont, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                    notification.setContentIntent(pendingIntent);

                    // Builds the notification and issues it
                    NotificationManager nm = (NotificationManager) cont.getSystemService(cont.NOTIFICATION_SERVICE);
                    Random r = new Random();

                    // Fire first notification
                    if (diff < 267) {

                        if (received == 0) {
                            if (diff >= 55 && diff < 90) {
                                // Fire notification 1
                                ticker = trimText(getString(R.string.notif_msg1));
                                notification.setTicker(ticker); // Sets the text displayed when notification is received
                                notification.setWhen(System.currentTimeMillis());
                                notification.setContentText(cont.getString(R.string.notif_msg1));
                                int rand = r.nextInt(1000);
                                nm.notify(rand, notification.build());

                                // Add the notification to the database
                                DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                                String nday = f.format(new Date().getTime());
                                String nmessage = cont.getString(R.string.notif_msg1);
                                notif = new Notification(nday, nmessage);
                                dbHandler.addNotification(notif);

                                // Increment received notifications count
                                received++;
                            }
                            else if (diff >= 90 && diff < 153) {
                                received = 1;
                            }
                            else if (diff >= 153 && diff < 174) {
                                received = 2;
                            }
                            else if (diff >= 174 && diff < 224) {
                                received = 3;
                            }
                            else if (diff >= 224 && diff < 231) {
                                received = 4;
                            }
                            else if (diff >= 231 && diff < 252) {
                                received = 5;
                            }
                            else if (diff >= 252 && diff < 259) {
                                received = 6;
                            }
                            else if (diff >= 259 && diff < 266) {
                                received = 7;
                            }
                            else if (diff == 266) {
                                received = 8;
                            }

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }

                    }

                    // Fire 2nd notification
                    if (diff >= 90 && diff < 153) {
                        if (received == 1) {
                            ticker = trimText(getString(R.string.notif_msg2));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg2));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg2);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                    else if (diff >= 153 && diff < 174) {
                        if (received == 2) {
                            ticker = trimText(getString(R.string.notif_msg3));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg3));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg3);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                    else if (diff >= 174 && diff < 224) {
                        if (received == 3) {
                            ticker = trimText(getString(R.string.notif_msg4));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg4));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg4);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                    else if (diff >= 224 && diff < 231) {
                        if (received == 4) {
                            ticker = trimText(getString(R.string.notif_msg5));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg5));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg5);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                    else if (diff >= 231 && diff < 252) {
                        if (received == 5) {
                            ticker = trimText(getString(R.string.notif_msg6));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg6));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg6);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                    else if (diff >= 252 && diff < 259) {
                        if (received == 6) {
                            ticker = trimText(getString(R.string.notif_msg7));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg7));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg7);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                    else if (diff >= 259 && diff < 266) {
                        if (received == 7) {
                            ticker = trimText(getString(R.string.notif_msg8));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg8));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg8);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                    else if (diff == 266) {
                        if (received == 8) {
                            ticker = trimText(getString(R.string.notif_msg9));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.notif_msg9));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.notif_msg9);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.deleteReceived();
                            dbHandler.addReceived(received);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // This is executed if lmp does not match expected pattern
                }
            }
        };

        Runnable r = new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };

        Thread stephThread = new Thread(r);
        stephThread.start();

        stopSelf();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // Trim notification ticker text
    public static String trimText(String text) {

        String trimmed = "";
        int requiredNum = 20;
        int currentNum = text.length();

        if(requiredNum >= currentNum) {
            trimmed = text;
        }
        else {
            for(int i = 0; i < requiredNum; i++) {
                trimmed += text.charAt(i);
            }
            trimmed += "...";
        }

        return trimmed;
    }

}
