package com.max.alfabanktesttask;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.Map;

//TODO
@FeignClient(name = "YesterdayExchangeRate", url = "")
public interface YesterdayExchangeRate {
    @GetMapping
    Map getYesterdayRate();
}
