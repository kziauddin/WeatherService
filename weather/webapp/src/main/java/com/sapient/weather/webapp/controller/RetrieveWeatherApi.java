package com.sapient.weather.webapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;

@RestController
public interface RetrieveWeatherApi {
	@GetMapping("/api/weather/")	
    public @ResponseBody ResponseEntity<ListWeatherResponse> listWeather(@RequestBody ListWeatherRequest body);
}
