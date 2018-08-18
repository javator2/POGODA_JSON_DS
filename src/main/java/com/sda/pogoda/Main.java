package com.sda.pogoda;

import com.sda.pogoda.model.Weather;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WeaterService weaterService = new WeaterService("http://api.apixu.com/v1/current.json", "b25f75b59648484499172849181808&");


        System.out.println("Podaj miasto:");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.next();
//        String url = "http://api.apixu.com/v1/current.json?key=b25f75b59648484499172849181808&" + "&q=" + city;
        scanner.close();

        System.out.println(weaterService.getCityWeather(city));

//
//
//        try {
//            System.out.println(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
//
//            JSONObject json = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
//            System.out.println("Pogoda w " + city + " wynosi " + json.getJSONObject("current").getJSONObject("condition").get("text"));
//            Weather weather = new Weather();
//            weather.setCity(json.getJSONObject("location").get("name").toString());
//            weather.setCountry(json.getJSONObject("location").get("country").toString());
//            weather.setIconUrl(json.getJSONObject("current").getJSONObject("condition").get("icon").toString());
//            weather.setTemp((Double)json.getJSONObject("current").get("temp_c"));
//            weather.setFeelsLikeTemp((Double)json.getJSONObject("current").get("feelslike_c"));
//            weather.setConditionText(json.getJSONObject("current").getJSONObject("condition").get("text").toString());
//
//            System.out.println(weather.toString());
//
//            POBIERANIA WSZYSTKICH KLUCZY:
//            Iterator<String> keys = json.keys();
//            Iterator<String> keys = json.getJSONObject("current").keys();
//            for (Iterator<String> it = keys; it.hasNext();){
//                String k = it.next();
//                System.out.println(k);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}
