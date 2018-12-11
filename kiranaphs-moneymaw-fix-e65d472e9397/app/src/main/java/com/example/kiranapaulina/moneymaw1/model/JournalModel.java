package com.example.kiranapaulina.moneymaw1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class JournalModel implements Parcelable{

    int id;
    double money;
    long date;
    boolean income;
    String desc;

    public JournalModel(int id, double money, long date, boolean income, String desc) {
        this.id = id;
        this.money = money;
        this.date = date;
        this.income = income;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public long getDate() {
        return date;
    }

    public boolean isIncome() {
        return income;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeDouble(this.money);
        dest.writeLong(this.date);
        dest.writeByte(this.income ? (byte) 1 : (byte) 0);
        dest.writeString(this.desc);
    }

    protected JournalModel(Parcel in) {
        this.id = in.readInt();
        this.money = in.readDouble();
        this.date = in.readLong();
        this.income = in.readByte() != 0;
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<JournalModel> CREATOR = new Parcelable.Creator<JournalModel>() {
        @Override
        public JournalModel createFromParcel(Parcel source) {
            return new JournalModel(source);
        }

        @Override
        public JournalModel[] newArray(int size) {
            return new JournalModel[size];
        }
    };

}
