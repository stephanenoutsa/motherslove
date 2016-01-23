package com.babyandi.stephnoutsa.babyandi;

import android.app.SearchManager;
import android.os.Bundle;
import android.app.ListActivity;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;

public class SearchableActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        // Get the intent, verify the action and get the query
        Intent i = getIntent();
        if (Intent.ACTION_SEARCH.equals(i.getAction())) {
            String query = i.getStringExtra(SearchManager.QUERY);
            //doMySearch(query);
        }
    }

}
