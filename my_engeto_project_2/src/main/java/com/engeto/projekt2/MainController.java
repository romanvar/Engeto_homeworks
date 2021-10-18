package com.engeto.projekt2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    List<VatRate> seznam = new ArrayList<>();
    public MainController(){}


    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello";
            }

            @GetMapping(path = "/rate")
        public VatRate getRate(){

               VatRate vatRate = new VatRate();
               vatRate.setRate(22.0);
               vatRate.setCountry("CZ");
               return vatRate;
            }

}
