package com.engeto.my_engeto_project2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TestMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        TestMain testMain   = new TestMain();
       String body =  testMain.callApi();

          VatResponse vatResponse =      testMain.mapToObject(body);

      System.out.println("last updated: "+vatResponse.getLastUpdated());


        System.out.println("ahoj");
        List<CountryVat> list = new ArrayList<>(vatResponse.getRates().values());
        Collections.sort(list);
        for(CountryVat countryVat : list){
            System.out.println(countryVat.getStandard_rate());
        }


    }

    public String callApi() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://euvatrates.com/rates.json")).GET().build();
       HttpResponse<String> httResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println("Status Code: "+httResponse.statusCode());
//        System.out.println("Body : "+httResponse.body());
        return httResponse.body();


    }
    public VatResponse mapToObject(String body) throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        VatResponse vatResponse = objectMapper.readValue(body,VatResponse.class);
//        System.out.println("Rates count: "+vatResponse.getRates().size());
        return vatResponse;

    }
}
