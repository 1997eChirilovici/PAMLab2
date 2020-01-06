package com.example.lab2.util;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String convertToDate(String rawDateFormat) {
        SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-M-dd");
        try {
            Date date = sourceDateFormat.parse(rawDateFormat);
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM dd, yyyy");
            if (date != null) {
                rawDateFormat = outputDateFormat.format(date);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return rawDateFormat;
    }

    public static String convertToTime(long timestamp) {

        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.setTimeInMillis(timestamp);
        return DateFormat.format("HH:mm", calendar).toString();
    }

    public static String convertToTimeAndDate(long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        return DateFormat.format("dd MMM, yyyy HH:mm", calendar).toString();
    }

    public static String convertToMinutesAndSeconds(long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        return DateFormat.format("mm:ss", calendar).toString();
    }

}
