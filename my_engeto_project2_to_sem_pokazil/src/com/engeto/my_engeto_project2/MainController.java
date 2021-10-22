package com.engeto.my_engeto_project2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping(path = "/hello")
    public String hello(){
        return "Ahoj vole";
    }
}
