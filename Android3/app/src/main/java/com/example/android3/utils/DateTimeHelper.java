package com.example.android3.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeHelper {

    private static final String CURRENT_DATETIME_PATTERN="dd/MM/yyyy HH:mm:ss";
    private static final String CURRENT_TIME_PATTERN="HH:mm:ss";

    public static String getCurrentDateTime(){

        Calendar cal=Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat(CURRENT_DATETIME_PATTERN, Locale.getDefault());

        return dateFormat.format(cal.getTime());
    }

    public static String parseDateToTime(double time){

        DateFormat dateFormat =new SimpleDateFormat(CURRENT_TIME_PATTERN,Locale.getDefault());

        Date date = new Date();
        date.setTime((long) time *1000);
        return dateFormat.format(date.getTime());

    }
}
