package com.max.alfabanktesttask.controllers;

import com.max.alfabanktesttask.rates.CurrentExchangeRate;
import com.max.alfabanktesttask.StringWrapper;
import com.max.alfabanktesttask.MapConverter;
import com.max.alfabanktesttask.rates.YesterdayExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class MainController {
    private final CurrentExchangeRate currentExchangeRate;
    private final YesterdayExchangeRate yesterdayExchangeRate;
    private MapConverter mapConverter = new MapConverter();


    @Autowired
    public MainController(CurrentExchangeRate currentExchangeRate, YesterdayExchangeRate yesterdayExchangeRate) {
        this.currentExchangeRate = currentExchangeRate;
        this.yesterdayExchangeRate = yesterdayExchangeRate;
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

        Map<String, Double> values = mapConverter.toStringDoubleMap((Map<String, ? extends Comparable<?>>) currentExchangeRate.getCurrentRate().get("rates"));
        Map<String, Double> YesterdayValues = mapConverter.toStringDoubleMap((Map<String, ? extends Comparable<?>>) yesterdayExchangeRate.getYesterdayRate().get("rates"));
        if(values.get(stringWrapper.getString()) >= YesterdayValues.get(stringWrapper.getString()))
            return "rich";
        else
            return "broke";


    }

}
