package com.babyandi.stephnoutsa.babyandi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WhenYoullDeliver extends AppCompatActivity {

    MyDBHandler dbHandler;
    String dbDate;
    int yr, mth, day;
    public GregorianCalendar selectedDate = new GregorianCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_youll_deliver);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        dbHandler = new MyDBHandler(this, null, null, 1);

        CalendarView date = (CalendarView) findViewById(R.id.calendarView);

        // Set maximum date to be displayed
        long max = date.getDate();
        date.setMaxDate(max);

        // Set minimum date to be displayed
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(Calendar.MONTH, -9);
        currentDate.add(Calendar.DAY_OF_MONTH, -7);
        long min = currentDate.getTimeInMillis();
        date.setMinDate(min);

        date.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public GregorianCalendar calendar;

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                this.calendar = new GregorianCalendar(year, month, dayOfMonth);
                yr = calendar.get(Calendar.YEAR);
                mth = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                selectedDate = new GregorianCalendar(yr, mth, day);
                //Put a toast on the screen for testing purposes
                //Toast.makeText(getApplicationContext(), calendar + "/" + mth + "/" + year, Toast.LENGTH_LONG).show();
            }
        });

    }

    // Function to retrieve selected date
    public void onClickSubmitDate(View view) {
        DateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        String date = sdf.format(selectedDate.getTime());
        LMP lmp = new LMP(date);
        dbHandler.addLMP(lmp);

        // Calculate the EDD
        selectedDate.add(Calendar.MONTH, -3);
        selectedDate.add(Calendar.YEAR, 1);
        selectedDate.add(Calendar.DAY_OF_MONTH, 7);

        // Save the EDD to the database
        String eddate = sdf.format(selectedDate.getTime());
        EDD edd = new EDD(eddate);
        dbHandler.addEDD(edd);

        // Start service
        Intent service = new Intent(this, MyService.class);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, service, 0);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                0, AlarmManager.INTERVAL_DAY,
                pendingIntent);

        // Enable receiver when device boots
        ComponentName receiver = new ComponentName(this, BootReceiver.class);
        PackageManager pm = this.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);

        Intent i = new Intent(this, ExpectedDateOfDelivery.class);
        startActivity(i);
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
