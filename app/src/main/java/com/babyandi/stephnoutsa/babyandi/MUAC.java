package com.babyandi.stephnoutsa.babyandi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static com.babyandi.stephnoutsa.babyandi.R.drawable.android;

public class MUAC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muac);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbarTitle);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Love Letters.ttf");
        toolbarTitle.setTypeface(font);
        setSupportActionBar(toolbar);

        //Set an Icon for navigation
        toolbar.setNavigationIcon(android);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        TextView muacText = (TextView) findViewById(R.id.muacText);
        TextView muac_image_text = (TextView) findViewById(R.id.muac_image_text);
        TextView muacInterpretation = (TextView) findViewById(R.id.muacInterpretation);
        TextView muacReading = (TextView) findViewById(R.id.muacReading);
        TextView muacReading1 = (TextView) findViewById(R.id.muacReading1);
        TextView muacReading2 = (TextView) findViewById(R.id.muacReading2);
        TextView muacReading3 = (TextView) findViewById(R.id.muacReading3);
        TextView significance = (TextView) findViewById(R.id.significance);
        TextView significance1 = (TextView) findViewById(R.id.significance1);
        TextView significance2 = (TextView) findViewById(R.id.significance2);
        TextView significance3 = (TextView) findViewById(R.id.significance3);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/mufferaw rg.ttf");
        muacText.setTypeface(typeface);
        muac_image_text.setTypeface(typeface);
        muacInterpretation.setTypeface(typeface);
        muacReading.setTypeface(typeface);
        muacReading1.setTypeface(typeface);
        muacReading2.setTypeface(typeface);
        muacReading3.setTypeface(typeface);
        significance.setTypeface(typeface);
        significance1.setTypeface(typeface);
        significance2.setTypeface(typeface);
        significance3.setTypeface(typeface);
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
