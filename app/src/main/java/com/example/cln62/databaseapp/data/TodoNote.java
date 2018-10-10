package com.example.cln62.databaseapp.data;

/**
 * This is a pojo class
 */

public class TodoNote {

    String title;
    String subTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public TodoNote(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }
}
