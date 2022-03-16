package com.detroitlabs.sunnyday.service;

import com.detroitlabs.sunnyday.model.Forecast;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    public Forecast fetchWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                "http://api.openweathermap.org" +
                        "/data/2.5/weather?q=tampa&" +
                        "APPID=8e905b565f83c3e81d4b0a536f28f2d0", Forecast.class);
    }
}
