package com.sapient.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sapient.weather.data.WeatherDao;
import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;

@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	WeatherDao weatherDao;
	
	@Override
	public ListWeatherResponse getWeatherResponse(ListWeatherRequest body) {
		ListWeatherResponse response; 
		
		ResponseEntity<ListWeatherResponse> strresponse = weatherDao.getWeatherData(body);
		
		response = strresponse.getBody();
		
		System.out.println(strresponse);
		return response;
	}

}
