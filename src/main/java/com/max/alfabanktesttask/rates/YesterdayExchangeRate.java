package com.max.alfabanktesttask.rates;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URL;
import java.util.Map;

@FeignClient(name = "YesterdayExchangeRate", url = "https://openexchangerates.org/api/historical/2020-01-11.json?app_id=e971a05b991a4942bdeeeb789b0f626f")
public interface YesterdayExchangeRate {
    @GetMapping
    Map getYesterdayRate();
}
