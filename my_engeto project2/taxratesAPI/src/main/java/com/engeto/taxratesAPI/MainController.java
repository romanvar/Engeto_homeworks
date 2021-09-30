package com.engeto.taxratesAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainController {

    HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)  // this is the default
            .build();

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://euvatrates.com/rates.json"))
            .GET()   // this is the default
            .build();

    HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    public MainController() throws IOException, InterruptedException {
    }
//System.out.println("Response status code: " + response.statusCode());
//System.out.println("Response headers: " + response.headers());
//System.out.println("Response body: " + response.body());
}
