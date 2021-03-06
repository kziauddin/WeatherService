package com.sapient.weather.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;
import com.sapient.weather.entity.WeatherWebResponse;


public interface WeatherService {
	public WeatherWebResponse getWeatherResponse(ListWeatherRequest body) throws Exception;
}
