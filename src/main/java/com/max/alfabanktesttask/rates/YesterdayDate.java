package com.max.alfabanktesttask.rates;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class YesterdayDate {
    public final static String getYesterdayDate(){
        Date yesterday = new Date(System.currentTimeMillis() - 1000L * 60L * 60L * 24L);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return  dateFormat.format(yesterday);
    }
}
