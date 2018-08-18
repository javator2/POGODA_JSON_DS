package com.sda.pogoda;

import com.sda.pogoda.model.Weather;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeaterService {

    private String finalUrl;

    public WeaterService(String url, String apiKey) {
        finalUrl = url + "?key=" + apiKey;
    }

    public Weather getCityWeather(String city) {
        Weather weather = new Weather();
        String requestUrl = finalUrl + "&q=" + city;

        JSONObject json = null;
        try {
            json = new JSONObject(IOUtils.toString(new URL(requestUrl), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        weather.setCity(json.getJSONObject("location").get("name").toString());
        weather.setCountry(json.getJSONObject("location").get("country").toString());
        weather.setIconUrl(json.getJSONObject("current").getJSONObject("condition").get("icon").toString());
        weather.setTemp((Double) json.getJSONObject("current").get("temp_c"));
        weather.setFeelsLikeTemp((Double) json.getJSONObject("current").get("feelslike_c"));
        weather.setConditionText(json.getJSONObject("current").getJSONObject("condition").get("text").toString());
        return weather;

    }
}
