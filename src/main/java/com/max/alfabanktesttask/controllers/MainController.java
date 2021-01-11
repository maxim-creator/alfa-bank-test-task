package com.max.alfabanktesttask.controllers;

import com.max.alfabanktesttask.rates.CurrentExchangeRate;
import com.max.alfabanktesttask.MyObject;
import com.max.alfabanktesttask.rates.YesterdayExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;


@Controller
public class MainController {
    private final CurrentExchangeRate currentExchangeRate;
    private final YesterdayExchangeRate yesterdayExchangeRate;


    @Autowired
    public MainController(CurrentExchangeRate currentExchangeRate, YesterdayExchangeRate yesterdayExchangeRate) {
        this.currentExchangeRate = currentExchangeRate;
        this.yesterdayExchangeRate = yesterdayExchangeRate;
    }


    @GetMapping
    public String mainPage(Model model){
        LinkedHashMap<String, Double> values = (LinkedHashMap<String, Double>) currentExchangeRate.getCurrentRate().get("rates");
        MyObject myObject = new MyObject(new ArrayList<>(values.keySet()));
        model.addAttribute("currentRates", myObject);
        return "MainPage";
    }

    @PostMapping("/rate")
    public String currency(@ModelAttribute("currentRates")MyObject myObject) {

        LinkedHashMap<String, Double> values = (LinkedHashMap<String, Double>) currentExchangeRate.getCurrentRate().get("rates");
        LinkedHashMap<String, Double> YesterdayValues = (LinkedHashMap<String, Double>) yesterdayExchangeRate.getYesterdayRate().get("rates");

        if(values.get(myObject.getS()) > YesterdayValues.get(myObject.getS()))
            return "rich";
        else
            return "broke";


    }

}
