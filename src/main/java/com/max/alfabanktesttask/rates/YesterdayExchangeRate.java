package com.max.alfabanktesttask.rates;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "YesterdayExchangeRate", url = "https://openexchangerates.org/api/historical/")
public interface YesterdayExchangeRate {
    @GetMapping(value = "{date}.json?app_id=e971a05b991a4942bdeeeb789b0f626f")
    Map getYesterdayRate(@PathVariable("date") String date);
}
