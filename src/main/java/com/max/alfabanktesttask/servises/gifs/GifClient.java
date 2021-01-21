package com.max.alfabanktesttask.servises.gifs;


import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import feign.okhttp.OkHttpClient;

import java.util.Map;

@Component
public class GifClient {
    @Value("${gif.api_key}")
    private String key;

    @Value("${gif.url}")
    private String url;

    public static <T> T createClient(Class<T> type, String uri){
        return Feign.builder()
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .target(type, uri);
    }
    public Map getRandomGif(String tag){
        return createClient(GifService.class, url).getGifJson(tag, key);
    }
}
