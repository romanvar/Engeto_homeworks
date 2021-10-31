package com.engeto.my_engeto_project2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    private List<CountryVat> list;
    private String body;
    private VatResponse vatResponse;

    public MainController() throws IOException, InterruptedException {
        init();
        System.out.println("Init finished");
//        System.out.println(body);
    }

    public void init() throws IOException, InterruptedException {

        TestMain testMain = new TestMain();
        body = testMain.callApi();
        vatResponse = testMain.mapToObject(body);
        list = new ArrayList<>(vatResponse.getRates().values());

    }

    @GetMapping(path = "/hello")
    public String hello() {
        return "Ahoj";
    }

    @GetMapping(path = "/getarraylist")
    public List<CountryVat> getString() {
        return list;


    }

    @GetMapping(path = "/getcz")
    public CountryVat getCz() {
        CountryVat c = vatResponse.getRates().get("CZ");
        return c;
    }

}
