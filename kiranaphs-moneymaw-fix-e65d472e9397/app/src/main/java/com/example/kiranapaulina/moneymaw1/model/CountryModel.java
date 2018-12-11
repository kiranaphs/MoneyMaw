package com.example.kiranapaulina.moneymaw1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CountryModel implements Parcelable {

    String name;
    double value;

    public CountryModel(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeDouble(this.value);
    }

    protected CountryModel(Parcel in) {
        this.name = in.readString();
        this.value = in.readDouble();
    }

    public static final Parcelable.Creator<CountryModel> CREATOR = new Parcelable.Creator<CountryModel>() {
        @Override
        public CountryModel createFromParcel(Parcel source) {
            return new CountryModel(source);
        }

        @Override
        public CountryModel[] newArray(int size) {
            return new CountryModel[size];
        }
    };
}
