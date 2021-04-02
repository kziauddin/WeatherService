package com.sapient.weather.data;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;


public interface WeatherDao {
	ResponseEntity<ListWeatherResponse> getWeatherData(ListWeatherRequest body);
}
