package com.max.alfabanktesttask.controllers;

import com.max.alfabanktesttask.CurrentExchangeRate;
import com.max.alfabanktesttask.MyObject;
import com.max.alfabanktesttask.YesterdayDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class MainController {
    private final CurrentExchangeRate currentExchangeRate;

    @Autowired
    public MainController(CurrentExchangeRate currentExchangeRate) {
        this.currentExchangeRate = currentExchangeRate;
    }

    @GetMapping
    public String mainPage(Model model){
        YesterdayDate.getUrl();
        LinkedHashMap<String, Double> values = (LinkedHashMap<String, Double>) currentExchangeRate.getCurrentRate().get("rates");
        MyObject myObject = new MyObject(new ArrayList<>(values.keySet()));
        model.addAttribute("currentRates", myObject);

        return "MainPage";
    }
    @PostMapping("/rate")
    public String currency(@ModelAttribute("currentRates")MyObject myObject){
        LinkedHashMap<String, Double> values = (LinkedHashMap<String, Double>) currentExchangeRate.getCurrentRate().get("rates");
        Double d = values.get(myObject.getS());
        return d.toString();
    }

}
