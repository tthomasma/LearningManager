package com.timthomasma.learningmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tim on 12/16/2014.
 */
public class CustomAdapter extends ArrayAdapter<LunchItem> {

    private Context context;
    private LunchItem[] data;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int textViewResourceId,
                         LunchItem[] lunch_data) {
        super(context, textViewResourceId, lunch_data);

        // store constructor parameters
        this.context = context;
        this.data = lunch_data;
        // store objects that will be used multiple times
        this.layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // if convertView isn't populated, use LayoutInflater to
        // create a new row layout
        View row = convertView;
        if (row == null) {
            row = this.layoutInflater.inflate(R.layout.custom_layout, null);
        }
        // extract data
        LunchItem item = this.data[position];
        // assign the caption
        TextView lunchTitle = (TextView) row.findViewById(R.id.textview);
        lunchTitle.setText(item.getTitle());
        // assign the icon
        ImageView lunchIcon = (ImageView) row.findViewById(R.id.imageview);

        lunchIcon.setImageResource(item.getIcon());
        return row;
    }

}
