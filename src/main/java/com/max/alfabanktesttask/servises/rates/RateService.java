package com.max.alfabanktesttask.servises.rates;

import feign.Param;
import feign.RequestLine;

import java.util.Map;

public interface RateService {
    //TODO base=usd
    @RequestLine("GET /latest.json?app_id={app_id}")
    Map getCurrentRate(@Param("app_id") String appId);

    @RequestLine("GET /historical/{date}.json?app_id={app_id}")
    Map getOldRate(@Param("date") String date, @Param("app_id") String app_id);
}
