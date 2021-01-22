package com.max.alfabanktesttask.servises.rates;

import com.max.alfabanktesttask.MapConverter;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Map;

@Component
public class RateClient {
    @Value("${rate.url}")
    private String rateUrl;
    @Value("${rate.app_id}")
    private  String rateAppId;
    MapConverter mapConverter = new MapConverter();

    public static <T> T createClient(Class<T> type, String uri){
        return Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .target(type, uri);
    }

    public Map getCurrentRate(){
        return createClient(RateService.class, rateUrl).getCurrentRate(rateAppId);
    }

    public Map getOldRate(String date){
        return createClient(RateService.class, rateUrl)
                .getOldRate(date, rateAppId);
    }

    public boolean isCurrentRateHigher(String rate){
        Map<String, Double> currentRate = mapConverter.toStringDoubleMap((Map<String, ? extends Comparable<?>>) getCurrentRate().get("rates"));
        Map<String, Double> oldRate = mapConverter.toStringDoubleMap((Map<String, ? extends Comparable<?>>) getOldRate(LocalDate.now().minus(1, ChronoUnit.DAYS).toString()).get("rates"));
        if(currentRate.get(rate) >= oldRate.get(rate))
            return true;
        else
            return false;
    }
}
