package com.timthomasma.learningmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, PopupMenu.OnMenuItemClickListener {

    private final static int FLY = 1;
    private final static int SCRAMBLE = 2;
    private final static int BALLOON = 3;
    private final static int SOUNDTEXT = 4;
    private final static int SOUNDIMAGE = 5;
    private final static int TEXTIMAGE = 6;
    private final static int IMAGETEXT = 7;
    PlaceItem lunch_data[];
    private PopupMenu popupMenu;

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
        popupMenu = new PopupMenu(this, findViewById(R.id.listview));
        popupMenu.getMenu().add(Menu.NONE, FLY, Menu.NONE, "Fly on Google Earth");
        popupMenu.getMenu().add(Menu.NONE, SCRAMBLE, Menu.NONE, "Word Scramble");
        popupMenu.getMenu().add(Menu.NONE, BALLOON, Menu.NONE, "Balloon Boy");
        popupMenu.setOnMenuItemClickListener(this);
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
        String nameOfClickedItem = lunch_data[position].getTitle();
        popupMenu.show();
//        Toast.makeText(this, "Clicked on '" + nameOfClickedItem + "'", Toast.LENGTH_SHORT).show();

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

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Picked " + item.getItemId(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case FLY:
//                tv.setText("ONE");
                break;
            case SCRAMBLE:
//                tv.setText("TWO");
                break;
            case BALLOON:
//                tv.setText("THREE");
                break;
            case SOUNDTEXT:
//                tv.setText("SOUNDTEXT");
                break;
            case SOUNDIMAGE:
//                tv.setText("SOUNDIMAGE");
                break;
            case TEXTIMAGE:
//                tv.setText("TEXTIMAGE");
                break;
            case IMAGETEXT:
//                tv.setText("TEXTIMAGE");
                break;
        }
        return false;
    }

}
