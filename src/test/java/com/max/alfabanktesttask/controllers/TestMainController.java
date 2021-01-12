package com.max.alfabanktesttask.controllers;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
public class TestMainController {

    WireMockServer wireMockServer = new WireMockServer(8070);

    @BeforeAll
    public void startMockServer(){
        wireMockServer.start();
    }

    @AfterAll
    public void stopMockServer(){
        wireMockServer.stop();
    }



}
