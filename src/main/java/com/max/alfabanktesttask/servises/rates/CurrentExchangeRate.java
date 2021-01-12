package com.max.alfabanktesttask.servises.rates;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "CurrentExchangeRate", url = "https://openexchangerates.org/api/latest.json?app_id=e971a05b991a4942bdeeeb789b0f626f")
public interface CurrentExchangeRate {
    @GetMapping()
    Map getCurrentRate();
}
