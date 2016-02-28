package com.babyandi.stephnoutsa.babyandi;

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class ExpectedDateOfDelivery extends AppCompatActivity {

    TextView eDDText;
    MyDBHandler dbHandler;
    SimpleDateFormat sdf;
    String eddate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expected_date_of_delivery);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set an icon for navigation
        toolbar.setNavigationIcon(R.drawable.android);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        dbHandler = new MyDBHandler(this, null, null, 1);
        eDDText = (TextView) findViewById(R.id.eDDText);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                eddate = dbHandler.getEDD();
                eDDText.setText(getResources().getString(R.string.edd_value));
                eDDText.append(eddate);
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
    }

}
