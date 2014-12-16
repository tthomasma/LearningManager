package com.timthomasma.learningmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LunchItem lunch_data[] = new LunchItem[]{
                new LunchItem(R.drawable.detroit, "Detroit"),
//                new LunchItem(R.drawable.hamburger, "Somewhere"),
                new LunchItem(R.drawable.pizza_slice, "Somewhere"),};
        // TODO put names of places into the database. Pictures can be handled like this, and same picture goes in Google Maps overlay

        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_layout,
                lunch_data);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

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


        //code to start Google Earth goes here, with try-catch block in case it doesn't exist.
//        if (position < 4) {
//            Intent intent = new Intent(this, MathActivity.class);
//            intent.putExtra("operation", items[position]);
//            startActivity(intent);
//        }
//        else {
//            Intent intent = new Intent(this, ReportActivity.class);
//            startActivity(intent);
//        Toast.makeText(this, "Clicked something", Toast.LENGTH_LONG).show();
//        }
        Toast.makeText(this, "Clicked something", Toast.LENGTH_LONG).show();
    }
}
