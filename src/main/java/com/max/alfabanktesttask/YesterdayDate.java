package com.max.alfabanktesttask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class YesterdayDate {
    public final static String getUrl(){
        Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s="https://openexchangerates.org/api/historical/";
        s += dateFormat.format(yesterday);
        s +=".json?app_id=e971a05b991a4942bdeeeb789b0f626f";
        return s;
    }
}
