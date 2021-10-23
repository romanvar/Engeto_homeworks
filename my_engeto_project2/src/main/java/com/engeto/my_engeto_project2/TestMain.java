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

    private final int ITEMS_DISPLAYED =3;


    public static void main(String[] args) throws IOException, InterruptedException {
        TestMain testMain   = new TestMain();
        String body =  testMain.callApi();
//        System.out.println(body);
        VatResponse vatResponse =      testMain.mapToObject(body);
        List<CountryVat> list = new ArrayList<>(vatResponse.getRates().values());
//        System.out.println("last updated: "+vatResponse.getLastUpdated());


        Collections.sort(list);
        for(CountryVat countryVat : list){
//            System.out.println(countryVat.getStandard_rate());
        }
//        System.out.println("delka seznamu: "+list.size());
        System.out.println("\nList of "+ testMain.ITEMS_DISPLAYED+" lowest standard tax rates:");
        for (int i= 0; i< testMain.ITEMS_DISPLAYED; i++){

           printItem(i,list);
        }
        System.out.println("\nList of "+ testMain.ITEMS_DISPLAYED+" highest standard tax rates:");
        for (int i = list.size(); i > (list.size()-testMain.ITEMS_DISPLAYED); i--){

           printItem(i-1,list);
        }
        SearchTaxRates.searchLowerThan(list);

        SearchTaxRates.searchByCountryCode(vatResponse.getRates());


    }

    public static void printItem(int i,List<CountryVat> list ) {
        CountryVat c= list.get(i);
        System.out.print("Country = "+c.getCountry());
        System.out.println(" Standard rate = "+c.getStandard_rate());
    }

    public String callApi() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://euvatrates.com/rates.json")).GET().build();
        HttpResponse<String> httResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

//        System.out.println("Body : "+httResponse.body());
        return httResponse.body();


    }
    public VatResponse mapToObject(String body) throws JsonProcessingException {
        ObjectMapper objectMapper =new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(body,VatResponse.class);


    }}
