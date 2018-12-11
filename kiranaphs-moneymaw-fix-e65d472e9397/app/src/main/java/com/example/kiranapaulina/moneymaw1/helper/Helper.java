package com.example.kiranapaulina.moneymaw1.helper;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Helper {

    public static String convertToIDR(double harga){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format((double)harga);
    }

    public static String getDateMonth(long data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(data);
        return calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) + " " + calendar.get(Calendar.YEAR);
    }

    private static DateFormat dateFormat1 = new SimpleDateFormat("MMM yyyy");

    public static String convertDateToString(Date date) {
        String strDate = "";
        strDate = dateFormat1.format(date);
        return strDate;
    }
}
