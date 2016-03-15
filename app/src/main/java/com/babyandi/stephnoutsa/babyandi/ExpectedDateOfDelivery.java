package com.babyandi.stephnoutsa.babyandi;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExpectedDateOfDelivery extends AppCompatActivity {

    TextView eDDText;
    MyDBHandler dbHandler;
    String eddate, hiv, hepatitis;
    CheckBox cHiv;
    CheckBox cHepatitis;

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

        cHiv = (CheckBox) findViewById(R.id.hiv);
        cHepatitis = (CheckBox) findViewById(R.id.hepatitis);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                eddate = dbHandler.getEDD();
                DateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                long currentDate = new GregorianCalendar().getTimeInMillis();
                try {
                    Date edDate = sdf.parse(eddate);
                    long date = edDate.getTime();

                    if (date <= currentDate) {
                        eDDText.setText(getResources().getString(R.string.edd_unhandled));
                    }
                    else {
                        eDDText.setText(getResources().getString(R.string.edd_value));
                        eDDText.append(eddate);
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
    }

    // When hiv checkbox is clicked
    public void hivClicked(View view) {
        if (cHiv.isChecked()) {
            hiv = "positive";
        }
        else {
            hiv = "negative";
        }
    }

    // When hepatitis checkbox is clicked
    public void hepatitisClicked(View view) {
        if (cHepatitis.isChecked()) {
            hepatitis = "positive";
        }
        else {
            hepatitis = "negative";
        }
    }

    // Handle the button click
    public void onSubmitSN(View view) {
        // Handle scenario where user does not click any checkbox
        if(hiv == null)
            hiv = "negative";
        if(hepatitis == null)
            hepatitis = "negative";

        // Add the user's choice(s) to the database
        SpecialNeed specialNeed = new SpecialNeed(hiv, hepatitis);
        dbHandler.addSN(specialNeed);

        Toast.makeText(this, "HIV: " + hiv + "\nHepatitis: " + hepatitis, Toast.LENGTH_LONG).show();
    }

    ////////////Intents for menu items////////////
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
        getMenuInflater().inflate(R.menu.menu_activities, menu);
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

        return super.onOptionsItemSelected(item);
    }

}
