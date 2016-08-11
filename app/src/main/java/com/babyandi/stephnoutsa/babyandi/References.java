package com.babyandi.stephnoutsa.babyandi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class References extends AppCompatActivity {

    ListView listView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Love Letters.ttf");
        toolbarTitle.setTypeface(font);
        setSupportActionBar(toolbar);

        // Set logo for navigation
        toolbar.setNavigationIcon(R.drawable.android);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        TextView refText = (TextView) findViewById(R.id.refText);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/mufferaw rg.ttf");
        refText.setTypeface(typeface);

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                List<int[]> refList = new ArrayList<>();

                // Add references
                int[] anc = {1};
                refList.add(anc);
                int[] diarrhoea = {2};
                refList.add(diarrhoea);
                int[] malnutrition = {3};
                refList.add(malnutrition);
                int[] sn = {4};
                refList.add(sn);
                int[] bfpos = {5};
                refList.add(bfpos);
                int[] bfposTwins = {6};
                refList.add(bfposTwins);

                // Get the references into an adapter's list
                ListAdapter listAdapter = new CustomRefAdapter(context, refList);

                // Set the adapter to display the references
                listView = (ListView) findViewById(R.id.refList);
                listView.setAdapter(listAdapter);
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
