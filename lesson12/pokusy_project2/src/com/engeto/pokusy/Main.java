package com.engeto.pokusy;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.json.JSONArray;
import org.json.JSONException;
import  org.json.JSONObject;



public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, JSONException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)  // this is the default
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://euvatrates.com/rates.json"))
                .GET()   // this is the default
                .build();

        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("Response status code: " + response.statusCode());
//        System.out.println("Response headers: " + response.headers());

//        System.out.println("Ted prijde body");
//        System.out.println("Tohle je Response body: " + response.body());
        String responseBody = (String) response.body();

//        System.out.println("Ted prijde string");
//        System.out.println(responseBody);
//        System.out.println("Tohle je Response body: " + response.body());
//        responseBody = "{'profiles': [{'name':'john', 'age': 44}, {'name':'Alex','age':11}]}";
//       String responseBodyChanged = responseBody.replace("\u0022" ,"\u0027");
//String responseBodyChanged = responseBody.replace("\"","\'");
//        System.out.println(" tady je to kurva se single quotes");
//        System.out.println(responseBodyChanged);

//        JSONObject myjson = new JSONObject(Kravovina_pomocnaTrida.moje);
//       JSONArray the_json_array = myjson.getJSONArray("profiles");
//        JSONArray the_json_array = myjson.getJSONArray("rates");


        JSONObject obj = new JSONObject(responseBody);
//        String pageName = obj.getJSONObject("last_updated").getString("last_updated");
        System.out.println(obj);

        JSONArray arr = obj.getJSONArray("rates");


        for (int i = 0; i < arr.length(); i++)
        {
            String country = arr.getJSONObject(i).getString("country");

        }



    }
}
