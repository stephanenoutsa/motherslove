package com.babyandi.stephnoutsa.babyandi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChildDOB extends AppCompatActivity {

    int yr, mth, day;
    public GregorianCalendar selectedDate = new GregorianCalendar();
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_dob);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Love Letters.ttf");
        toolbarTitle.setTypeface(font);
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

        TextView dobText = (TextView) findViewById(R.id.dobText);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/mufferaw rg.ttf");
        dobText.setTypeface(typeface);

        DatePicker date = (DatePicker) findViewById(R.id.datePicker);

        // Set maximum date to be displayed
        GregorianCalendar currentDate = new GregorianCalendar();
        GregorianCalendar maxDate = new GregorianCalendar();
        maxDate.add(Calendar.DAY_OF_WEEK, 1);
        long max = maxDate.getTimeInMillis();
        date.setMaxDate(max);

        // Set minimum date to be displayed
        GregorianCalendar minDate = new GregorianCalendar();
        minDate.add(Calendar.MONTH, -9);
        long min = minDate.getTimeInMillis();
        date.setMinDate(min);

        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH);
        int today = currentDate.get(Calendar.DAY_OF_MONTH);

        date.init(year, month, today, new DatePicker.OnDateChangedListener() {
            public GregorianCalendar calendar;
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                this.calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
                yr = calendar.get(Calendar.YEAR);
                mth = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                selectedDate = new GregorianCalendar(yr, mth, day);
                //Put a toast on the screen for testing purposes
                //Toast.makeText(getApplicationContext(), day + "/" + mth + "/" + yr, Toast.LENGTH_LONG).show();
            }
        });

    }

    // Function to retrieve selected date
    public void onClickSubmitDob(View view) {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dob = sdf.format(selectedDate.getTime());

                Intent intent = new Intent(context, AllowImmNotif.class);
                intent.putExtra("dob", dob);
                startActivity(intent);
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
