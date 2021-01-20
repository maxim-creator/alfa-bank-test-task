package com.max.alfabanktesttask.servises.rates;

import com.max.alfabanktesttask.MapConverter;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Service
@Data
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
        Map<String, Double> yesterdayValues = mapConverter.toStringDoubleMap((Map<String, ? extends Comparable<?>>) yesterdayExchangeRate.getYesterdayRate(LocalDate.now().minus(1, ChronoUnit.DAYS).toString()).get("rates"));
        if(values.get(rate) >= yesterdayValues.get(rate))
            return true;
        else
            return false;
    }
}
