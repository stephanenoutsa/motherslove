package com.babyandi.stephnoutsa.babyandi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.NotificationManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notifications extends AppCompatActivity {

    MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
    List<Notification> notificationList;
    ListView listView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Love Letters.ttf");
        toolbarTitle.setTypeface(font);
        setSupportActionBar(toolbar);

        // Set an android for navigation
        toolbar.setNavigationIcon(R.drawable.android);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        // Remove notification(s) from notification tray
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
        nMgr.cancelAll();

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                GridView gridView = (GridView) findViewById(R.id.gridview);

                // Get all notifications from database
                notificationList = dbHandler.getAllNotifications();

                int count = dbHandler.getNotificationsCount();
                if (count == 0) {
                    gridView.setVisibility(View.INVISIBLE);
                }

                // Reverse the order of the notifications
                Collections.reverse(notificationList);

                // Get the notifications into an adapter's list
                ListAdapter listAdapter = new CustomAdapter(context, notificationList);

                // Set the adapter to display the notifications
                listView = (ListView) findViewById(R.id.notificationsList);
                listView.setAdapter(listAdapter);

                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                        Notification notification = (Notification) parent.getItemAtPosition(position);
                        final String _nid = "\'" + notification.get_nid() + "\'";
                        new AlertDialog.Builder(context).setIcon(R.drawable.delete).
                                setTitle(getString(R.string.item_delete_title)).
                                setMessage(getString(R.string.item_delete_warning)).
                                setPositiveButton(getString(R.string.item_delete_ok), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dbHandler.deleteNotification(_nid);
                                        Intent intent = new Intent(Notifications.this, Notifications.class);
                                        finish();
                                        overridePendingTransition(0, 0);
                                        startActivity(intent);
                                        overridePendingTransition(0, 0);
                                        //Toast.makeText(context, _nid, Toast.LENGTH_SHORT).show();
                                    }
                                }).setNegativeButton(getString(R.string.item_delete_cancel), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                        }).show();

                        return true;
                    }
                });

                // Set list of texts for stop buttons
                List<String> stopList = new ArrayList<>();
                stopList.add(getString(R.string.stop_anc_notifs));
                stopList.add(getString(R.string.stop_imm_notifs));

                // Set adapter for stop buttons
                ListAdapter listAdapter1 = new CustomNotifAdapter(context, stopList);
                gridView.setAdapter(listAdapter1);

            }
        };

        Runnable r = new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(r);
        thread.start();

    }

    ////////////Intents for menu items////////////
    public void onClickHome() {
        Intent i = new Intent(this, HomeScreen.class);
        startActivity(i);
    }

    public void onClickAnc() {
        Intent i = new Intent(this, ANC.class);
        startActivity(i);
    }

    public void onClickMalnutrition() {
        Intent i = new Intent(this, Malnutrition.class);
        startActivity(i);
    }

    public void onClickDiarrhoea() {
        Intent i = new Intent(this, Diarrhoea.class);
        startActivity(i);
    }

    public void onClickSpecialNeeds() {
        Intent i = new Intent(this, SpecialNeeds.class);
        startActivity(i);
    }
    ////////////////End of Intents/////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.search) {
            onSearchRequested();
            return true;
        }*/
        if (id == R.id.notifications) {
            Intent i = new Intent(this, Notifications.class);
            startActivity(i);
        }
        if (id == R.id.about) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }
        if (id == R.id.go_to_home) {
            onClickHome();
            return true;
        }
        if (id == R.id.go_to_anc) {
            onClickAnc();
            return true;
        }
        if (id == R.id.go_to_malnutrition) {
            onClickMalnutrition();
            return true;
        }
        if (id == R.id.go_to_diarrhoea) {
            onClickDiarrhoea();
            return true;
        }
        if (id == R.id.go_to_special_needs) {
            onClickSpecialNeeds();
            return true;
        }
        if (id == R.id.go_to_ref) {
            Intent i = new Intent(this, References.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
