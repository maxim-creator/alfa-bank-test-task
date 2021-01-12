package com.max.alfabanktesttask.rates;

import com.max.alfabanktesttask.MapConverter;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RatesService {
    CurrentExchangeRate currentExchangeRate;
    YesterdayExchangeRate yesterdayExchangeRate;
    MapConverter mapConverter = new MapConverter();

    public RatesService(CurrentExchangeRate currentExchangeRate, YesterdayExchangeRate yesterdayExchangeRate) {
        this.currentExchangeRate = currentExchangeRate;
        this.yesterdayExchangeRate = yesterdayExchangeRate;
    }

    public boolean isCurrentRateHigher(String rate){
        Map<String, Double> values = mapConverter.toStringDoubleMap((Map<String, ? extends Comparable<?>>) currentExchangeRate.getCurrentRate().get("rates"));
        Map<String, Double> yesterdayValues = mapConverter.toStringDoubleMap((Map<String, ? extends Comparable<?>>) yesterdayExchangeRate.getYesterdayRate(YesterdayDate.getYesterdayDate()).get("rates"));
        if(values.get(rate) > yesterdayValues.get(rate))
            return true;
        else
            return false;
    }
}
