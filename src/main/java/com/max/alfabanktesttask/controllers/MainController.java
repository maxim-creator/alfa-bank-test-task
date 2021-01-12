package com.max.alfabanktesttask.controllers;

import com.max.alfabanktesttask.StringWrapper;
import com.max.alfabanktesttask.servises.gifs.Gif;
import com.max.alfabanktesttask.servises.rates.CurrentExchangeRate;

import com.max.alfabanktesttask.servises.rates.RatesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class MainController {
    private CurrentExchangeRate currentExchangeRate;
    private RatesService ratesService;
    private Gif gif;



    @Autowired
    public MainController(CurrentExchangeRate currentExchangeRate, RatesService ratesService, Gif gif) {
        this.currentExchangeRate = currentExchangeRate;
        this.ratesService = ratesService;
        this.gif=gif;
    }


    @GetMapping
    public String mainPage(Model model){
        LinkedHashMap<String, Double> values = (LinkedHashMap<String, Double>) currentExchangeRate.getCurrentRate().get("rates");
        model.addAttribute("stringWrapper", new StringWrapper());
        model.addAttribute("currencies", new ArrayList<>(values.keySet()));
        return "MainPage";
    }

    @PostMapping("/showGif")
    public String currency(@ModelAttribute("stringWrapper") StringWrapper stringWrapper, Model model) {
        Map<String, String> map;
        if(ratesService.isCurrentRateHigher(stringWrapper.getString()))
            map = (Map) gif.getJson("rich").get("data");
        else
            map = (Map) gif.getJson("broke").get("data");

        model.addAttribute("gifUrl", map.get("image_original_url"));
        return "showGifPage";

    }

}
