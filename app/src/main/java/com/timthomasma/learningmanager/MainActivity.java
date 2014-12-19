package com.timthomasma.learningmanager;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private final static String FLY = "Fly on Google Earth";
    private final static String SCRAMBLE = "Word Scramble";
    private final static String BALLOON = "Balloon Boy";
    private final static String SOUNDTEXT = "Pick Text to Match Sound";
    private final static String SOUNDIMAGE = "Pick Picture to Match Sound";
    private final static String TEXTIMAGE = "Pick Picture to Match Text";
    private final static String IMAGETEXT = "Pick Text to Match Picture";
    PlaceItem placeData[];
    String nameOfClickedItem;
    String activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupdata();

        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_layout,
                placeData);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

    }

    void setupdata() {
        PlaceItem li;
        ArrayList<PlaceItem> lunchDataList = new ArrayList<PlaceItem>();
        li = new PlaceItem(R.drawable.detroit, "Detroit");
        lunchDataList.add(li);
        li = new PlaceItem(R.drawable.afghanistan, "Afghanistan");
        lunchDataList.add(li);
        li = new PlaceItem(R.drawable.sydney, "Sydney, Australia");
        lunchDataList.add(li);
        PlaceItem listOfLunch[] = new PlaceItem[lunchDataList.size()];
        listOfLunch = lunchDataList.toArray(listOfLunch);
        placeData = listOfLunch;
        // TODO put names of places into the database. Pictures can be handled like this, and same picture goes in Google Maps overlay
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        nameOfClickedItem = placeData[position].getTitle();
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        //Inflating the Popup using xml file
        popup.getMenuInflater()
                .inflate(R.menu.popup_menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                activityName = "" + item.getTitleCondensed();
                goThere();
                return true;
            }
        });

        popup.show(); //showing popup menu
    }

    void goThere() {
        switch (activityName) {
            case FLY: {
                Toast.makeText(
                        MainActivity.this,
                        "Fly to: " + nameOfClickedItem,
                        Toast.LENGTH_SHORT
                ).show();
                flyTo(nameOfClickedItem);
                break;
            }
            case SCRAMBLE: {
                Toast.makeText(
                        MainActivity.this,
                        "Word scramble: " + nameOfClickedItem,
                        Toast.LENGTH_SHORT
                ).show();
                break;
            }
            case BALLOON: {
                Toast.makeText(
                        MainActivity.this,
                        "Balloon Boy: " + nameOfClickedItem,
                        Toast.LENGTH_SHORT
                ).show();
                break;
            }
            case SOUNDTEXT: {
                Toast.makeText(
                        MainActivity.this,
                        "Sound to text: " + nameOfClickedItem,
                        Toast.LENGTH_SHORT
                ).show();
                break;
            }
            case SOUNDIMAGE: {
                Toast.makeText(
                        MainActivity.this,
                        "Sound to picture: " + nameOfClickedItem,
                        Toast.LENGTH_SHORT
                ).show();
                break;
            }
            case TEXTIMAGE: {
                Toast.makeText(
                        MainActivity.this,
                        "Text to picture: " + nameOfClickedItem,
                        Toast.LENGTH_SHORT
                ).show();
                break;
            }
            case IMAGETEXT: {
                Toast.makeText(
                        MainActivity.this,
                        "Picture to text: " + nameOfClickedItem,
                        Toast.LENGTH_SHORT
                ).show();
                break;
            }
        }
    }

    void flyTo(String placeName) {
        //                send intent to Google Earth with geo description. How to do intents:
//                    Intent intent = new Intent(this, MathActivity.class);
//                    intent.putExtra("operation", items[position]);
//                    startActivity(intent);

        // the new intent we will launch
        Intent myIntent = new Intent();

        // send the intent directly to the google earth activity that can
        // handle search
        myIntent.setClassName("com.google.earth",
                "com.google.earth.EarthActivity");

        // we are doing a search query
        myIntent.setAction(Intent.ACTION_SEARCH);

        // change this address to any address you want to fly to
        myIntent.putExtra(SearchManager.QUERY, placeName);

        // always trap for ActivityNotFound in case Google earth is not on the device

        try {
            // launch google earth and fly to location
            this.startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(
                    MainActivity.this,
                    "Sorry, Google Earth is not available on this machine.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
