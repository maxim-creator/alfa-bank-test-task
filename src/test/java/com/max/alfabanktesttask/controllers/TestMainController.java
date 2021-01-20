package com.max.alfabanktesttask.controllers;

import com.max.alfabanktesttask.servises.rates.CurrentExchangeRate;
import com.max.alfabanktesttask.servises.rates.RatesService;
import com.max.alfabanktesttask.servises.rates.YesterdayExchangeRate;
import org.apache.http.client.UserTokenHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TestMainController {


    @Test
    public void testRatesService(){
    };

}
