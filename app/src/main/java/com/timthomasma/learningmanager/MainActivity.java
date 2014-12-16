package com.timthomasma.learningmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    LunchItem lunch_data[];

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
        LunchItem li;
        ArrayList<LunchItem> lunchDataList = new ArrayList<LunchItem>();
        li = new LunchItem(R.drawable.detroit, "Detroit");
        lunchDataList.add(li);
        li = new LunchItem(R.drawable.hamburger, "Somewhere");
        lunchDataList.add(li);
//        li = new LunchItem(R.drawable.detroit, "2Detroit");
//        lunchDataList.add(li);
//        li = new LunchItem(R.drawable.hamburger, "2Somewhere");
//        lunchDataList.add(li);
//        li = new LunchItem(R.drawable.detroit, "3Detroit");
//        lunchDataList.add(li);
//        li = new LunchItem(R.drawable.hamburger, "3Somewhere");
//        lunchDataList.add(li);
//        li = new LunchItem(R.drawable.detroit, "4Detroit");
//        lunchDataList.add(li);
//        li = new LunchItem(R.drawable.hamburger, "4Somewhere");
//        lunchDataList.add(li);
//        li = new LunchItem(R.drawable.pizza_slice, "5Somewhere");
//        lunchDataList.add(li);
        LunchItem listOfLunch[] = new LunchItem[lunchDataList.size()];
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
        String nameOfClickedItem = lunch_data[position].getTitle();
        Toast.makeText(this, "Clicked on '" + nameOfClickedItem + "'", Toast.LENGTH_LONG).show();

        //after context menu, code to start Google Earth goes here, with try-catch block in case it doesn't exist.
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
