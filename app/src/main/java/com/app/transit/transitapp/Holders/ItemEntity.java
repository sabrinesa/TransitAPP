package com.app.transit.transitapp.Holders;

import android.graphics.Bitmap;

/**
 * Created by asus on 12/11/2017.
 */

public class ItemEntity {
    private String title;
    private Bitmap image;

    public ItemEntity(String title, Bitmap image) {
        this.title = title;
        this.image = image;
    }

    public ItemEntity(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
