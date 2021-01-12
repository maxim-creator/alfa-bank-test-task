package com.max.alfabanktesttask.servises.gifs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Map;

@FeignClient(name = "gif", url = "https://api.giphy.com/v1/gifs/random")
public interface Gif {
    @GetMapping(value = "?tag={tag}&api_key=C2zDKwlmECj6Ijo05mzMfsp2CaZD3S4k")
    public Map getJson(@PathVariable("tag") String tag);


}
