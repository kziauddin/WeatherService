package com.sapient.weather.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.weather.common.constants.CommonConstants;
import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;
import com.sapient.weather.service.WeatherService;


@RestController
public class RetrieveWeatherApiController implements RetrieveWeatherApi  {
   
	@Autowired
	WeatherService weatherService;
	
	@Override
	public @ResponseBody ResponseEntity<ListWeatherResponse> listWeather(@RequestBody ListWeatherRequest body) {
		ListWeatherResponse response = new ListWeatherResponse();
		
		if (validateRequest()) {
			response = weatherService.getWeatherResponse(body);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public Boolean validateRequest() {
		
		return true;
	}
	
}
