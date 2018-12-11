package com.example.kiranapaulina.moneymaw1.model;

public class DateModel extends ListItem {

    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int getType() {
        return TYPE_DATE;
    }
}
