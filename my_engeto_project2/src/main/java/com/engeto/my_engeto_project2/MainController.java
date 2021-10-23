package com.engeto.my_engeto_project2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    public MainController() throws IOException, InterruptedException {
    init();
    }
    public void init() throws IOException, InterruptedException {

        TestMain testMain   = new TestMain();
        String body =  testMain.callApi();
        VatResponse vatResponse =      testMain.mapToObject(body);
        List<CountryVat> list = new ArrayList<>(vatResponse.getRates().values());
    }

    @GetMapping(path = "/hello")
    public String hello(){
        return "Ahoj";
    }
}
