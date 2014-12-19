package com.timthomasma.learningmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private final static int FLY = 1;
    private final static int SCRAMBLE = 2;
    private final static int BALLOON = 3;
    private final static int SOUNDTEXT = 4;
    private final static int SOUNDIMAGE = 5;
    private final static int TEXTIMAGE = 6;
    private final static int IMAGETEXT = 7;
    PlaceItem lunch_data[];
    String nameOfClickedItem;
    String activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupdata();

        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_layout,
                lunch_data);

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
        lunch_data = listOfLunch;
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
        nameOfClickedItem = lunch_data[position].getTitle();
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
        Toast.makeText(
                MainActivity.this,
                "You chose: " + activityName + " " + nameOfClickedItem,
                Toast.LENGTH_SHORT
        ).show();
        //after popup menu, code to start Google Earth goes here, with try-catch block in case it doesn't exist.
//        if (position < 4) {
//            Intent intent = new Intent(this, MathActivity.class);
//            intent.putExtra("operation", items[position]);
//            startActivity(intent);
//        }
//        else {
//            Intent intent = new Intent(this, ReportActivity.class);
//            startActivity(intent);
//        }
    }


}
