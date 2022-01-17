package com.surfer.controllers;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.surfer.Entities.Beach;
import com.surfer.Entities.Weather;
import com.surfer.repositories.BeachRepository;
import com.surfer.request.UpdateBeachRequest;
import com.surfer.request.AddBeachRequest;
import com.surfer.request.AddWeatherRequest;
import com.surfer.services.BeachService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/weather/")
public class WeatherController {

    @Autowired
    private BeachService beachService;

    @PostMapping("/")
    public void postWeatherReport(@RequestBody AddWeatherRequest request) {
        beachService.addWeather(request);
    }

}