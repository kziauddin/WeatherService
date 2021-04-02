package com.sapient.weather.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;


public interface WeatherService {
	public ListWeatherResponse getWeatherResponse(ListWeatherRequest body);
}
