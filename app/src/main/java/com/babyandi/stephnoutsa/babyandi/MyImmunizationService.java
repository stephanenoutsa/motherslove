package com.babyandi.stephnoutsa.babyandi;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyImmunizationService extends Service {

    NotificationCompat.Builder notification;
    Notification notif;
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    SimpleDateFormat sdf;
    Date dob;
    Date today;
    Context context = this;

    public MyImmunizationService() {
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

        String expectedPattern = "dd/MM/yyyy";
        sdf = new SimpleDateFormat(expectedPattern);

        notification = new NotificationCompat.Builder(cont);
        notification.setAutoCancel(true); // Delete notification from screen after user has viewed it.

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                try {
                    String ticker;

                    // Get the received number from database
                    int received = dbHandler.getDreceived();

                    // Check which notification to display, if any
                    DOB d = dbHandler.getDOB();
                    String dday = d.getDday();
                    String expectedPattern = "dd/MM/yyyy";
                    sdf = new SimpleDateFormat(expectedPattern);

                    dob = sdf.parse(dday);
                    today = new Date();
                    long diffInMs = today.getTime() - dob.getTime();
                    long diff =  diffInMs / (1000 * 60 * 60 * 24);

                    // Build the notification for the Immunization schedule
                    notification.setSmallIcon(R.drawable.android); // Sets icon to be displayed at the top of the screen
                    notification.setContentTitle(cont.getString(R.string.notification_title));
                    notification.setSound(alarmSound);
                    Intent i = new Intent(cont, Notifications.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(cont, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                    notification.setContentIntent(pendingIntent);

                    // Builds the notification and issues it
                    NotificationManager nm = (NotificationManager) cont.getSystemService(cont.NOTIFICATION_SERVICE);
                    Random r = new Random();

                    // Fire welcome notification
                    if(diff < 302) {
                        if(received == 0) {
                            ticker = trimText(getString(R.string.welcome_msg));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.welcome_msg));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.welcome_msg);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received messages count
                            if (diff < 12) {
                                received = 1;
                            }
                            else if (diff >= 12 && diff < 26) {
                                received = 2;
                            }
                            else if (diff >= 26 && diff < 39) {
                                received = 3;
                            }
                            else if (diff >= 39 && diff < 49) {
                                received = 4;
                            }
                            else if (diff >= 49 && diff < 77) {
                                received = 5;
                            }
                            else if (diff >= 77 && diff < 186) {
                                received = 6;
                            }
                            else if (diff >= 186 && diff < 273) {
                                received = 7;
                            }
                            else if (diff >= 273 && diff < 302) {
                                received = 8;
                            }

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Week one message
                    if(diff >= 4 && diff < 12) {
                        if (received == 1) {
                            ticker = trimText(getString(R.string.msg2));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg2));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg2);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Week three message
                    else if(diff >= 12 && diff < 26) {
                        if(received == 2) {
                            ticker = trimText(getString(R.string.msg3));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg3));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg3);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Week six message
                    else if (diff >= 26 && diff < 39) {
                        if (received == 3) {
                            ticker = trimText(getString(R.string.msg4));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg4));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg4);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Week ten message
                    else if (diff >= 39 && diff < 49) {
                        if (received == 4) {
                            ticker = trimText(getString(R.string.msg5));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg5));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg5);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Week fourteen message
                    else if (diff >= 67 && diff < 77) {
                        if (received == 5) {
                            ticker = trimText(getString(R.string.msg6));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg6));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg6);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Week 14 message
                    else if (diff >= 95 && diff < 105) {
                        if (received == 6) {
                            ticker = trimText(getString(R.string.msg7));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg7));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg7);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Month 6 message
                    else if (diff >= 168 && diff < 197) {
                        if (received == 7) {
                            ticker = trimText(getString(R.string.msg8));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg8));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg8);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                    // Conclusion message
                    else if (diff >= 273 && diff < 302) {
                        if (received == 8) {
                            ticker = trimText(getString(R.string.msg9));
                            notification.setTicker(ticker); // Sets the text displayed when notification is received
                            notification.setWhen(System.currentTimeMillis());
                            notification.setContentText(cont.getString(R.string.msg9));
                            int rand = r.nextInt(1000);
                            nm.notify(rand, notification.build());

                            // Add the notification to the database
                            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                            String nday = f.format(new Date().getTime());
                            String nmessage = cont.getString(R.string.msg9);
                            notif = new Notification(nday, nmessage);
                            dbHandler.addNotification(notif);

                            // Increment received notifications count
                            received++;

                            //Update received number in database
                            dbHandler.addDreceived(received);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
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
