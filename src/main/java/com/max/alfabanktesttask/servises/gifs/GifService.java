package com.max.alfabanktesttask.servises.gifs;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Map;

public interface GifService {
    @RequestLine("GET ?tag={tag}&api_key={api_key}")
    Map getGifJson(@Param("tag") String tag, @Param("api_key") String apiKey);


}
