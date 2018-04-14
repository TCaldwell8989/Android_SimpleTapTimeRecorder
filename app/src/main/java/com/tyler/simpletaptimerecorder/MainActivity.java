package com.tyler.simpletaptimerecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //global variables
    Date date;
    SimpleDateFormat sdf;
    String time;
    ListView timeListView;
    Button btnDateTime;

    //To store the time items
    ArrayList<String> timeListItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to widgets
        btnDateTime = (Button) findViewById(R.id.tap_time_button);
        timeListView = (ListView) findViewById(R.id.simple_list);

        // set up date format so it displays the time (ex. 12:30:15 pm)
        sdf = new SimpleDateFormat("h:mm:ss a", Locale.US);

        // Create ArrayAdapter, timeListItems ArrayList as data source
        final ArrayAdapter<String> timeListAdapter =
                new ArrayAdapter<String>(this, R.layout.list_item, R.id.list_item_text, timeListItems);

        timeListView.setAdapter(timeListAdapter);

        // Add listener to the button, to add time user clicked to ListView
        btnDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get current Date/Time, use format made earlier
                date = new Date();
                time = sdf.format(date);
                // Add the time to the ListView and notify data change
                timeListItems.add(time);
                timeListAdapter.notifyDataSetChanged();

            }
        });

    }
}
