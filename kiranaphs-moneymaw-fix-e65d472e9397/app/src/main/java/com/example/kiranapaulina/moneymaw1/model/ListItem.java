package com.example.kiranapaulina.moneymaw1.model;

public abstract class ListItem {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_DATE = 1;
    public static final int TYPE_GENERAL = 2;
    abstract public int getType();
}
