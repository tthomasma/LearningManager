package com.timthomasma.learningmanager;

/**
 * Created by Tim on 12/16/2014.
 */
public class PlaceItem {
    public int icon;
    public String title;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PlaceItem(int icon, String title) {
        super();
        this.icon = icon;
        this.title = title;
    }
}
