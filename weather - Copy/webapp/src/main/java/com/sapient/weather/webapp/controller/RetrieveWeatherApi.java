package com.sapient.weather.webapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;
import com.sapient.weather.entity.WeatherWebResponse;

@CrossOrigin
@RestController
public interface RetrieveWeatherApi {
	@PostMapping("/api/weather/")	
    public @ResponseBody ResponseEntity<WeatherWebResponse> listWeather(@RequestBody ListWeatherRequest body);
}
