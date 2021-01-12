package com.max.alfabanktesttask.controllers;

import com.max.alfabanktesttask.rates.CurrentExchangeRate;
import com.max.alfabanktesttask.StringWrapper;
import com.max.alfabanktesttask.MapConverter;
import com.max.alfabanktesttask.rates.RatesService;
import com.max.alfabanktesttask.rates.YesterdayDate;
import com.max.alfabanktesttask.rates.YesterdayExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class MainController {
    private CurrentExchangeRate currentExchangeRate;
    private YesterdayExchangeRate yesterdayExchangeRate;
    private RatesService ratesService;



    @Autowired
    public MainController(CurrentExchangeRate currentExchangeRate, YesterdayExchangeRate yesterdayExchangeRate, RatesService ratesService) {
        this.currentExchangeRate = currentExchangeRate;
        this.yesterdayExchangeRate = yesterdayExchangeRate;
        this.ratesService = ratesService;
    }


    @GetMapping
    public String mainPage(Model model){
        LinkedHashMap<String, Double> values = (LinkedHashMap<String, Double>) currentExchangeRate.getCurrentRate().get("rates");
        model.addAttribute("stringWrapper", new StringWrapper());
        model.addAttribute("currencies", new ArrayList<>(values.keySet()));
        return "MainPage";
    }

    @PostMapping("/showGif")
    public String currency(@ModelAttribute("stringWrapper") StringWrapper stringWrapper) {

        if(ratesService.isCurrentRateHigher(stringWrapper.getString()))
            return "rich";
        else
            return "broke";


    }

}
