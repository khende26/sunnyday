package com.detroitlabs.sunnyday.controller;

import com.detroitlabs.sunnyday.model.Forecast;
import com.detroitlabs.sunnyday.model.Temperature;
import com.detroitlabs.sunnyday.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
    WeatherService weatherService = new WeatherService();


    @ResponseBody
    @RequestMapping("/")
    public String displayWeather() {
        Forecast forecast = weatherService.fetchWeatherData();
        Temperature temperature = forecast.getTemperature();
        double fahrenheit  = Math.round(1.8 *(temperature.getTemp() - 273.15) + 32);
        int humidity = temperature.getHumidity();

        return forecast.getName() + ": " + (temperature.getTemp())+" degrees in Kelvin, "
                + fahrenheit + "  degrees in fahrenheit, with the humidity being "
                + temperature.getHumidity() + "%.  Today shows ";

    }
}
