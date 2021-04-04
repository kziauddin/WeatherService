package com.sapient.weather.data;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sapient.weather.common.constants.CommonConstants;
import com.sapient.weather.entity.ListWeatherRequest;
import com.sapient.weather.entity.ListWeatherResponse;

@Component
public class WeatherDaoImpl implements WeatherDao {

	@Override
	public ResponseEntity<ListWeatherResponse> getWeatherData(ListWeatherRequest body) {
		//TODO : check other input parameters and build the url
		String url = CommonConstants.ENDPOINT + "?q=" + body.getQ() + "&appid=" + CommonConstants.API_KEY;
		url += "&units=metric";
		if (body.getCnt() != 0) {
			url += "&cnt=" + body.getCnt();
		}
		
		System.out.println(url);
		RestTemplate rst = new RestTemplate();
		
		
		ResponseEntity<ListWeatherResponse> response = rst.getForEntity(url, ListWeatherResponse.class);
		
		return response;
	}

}
