package com.sapient.weather.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherWebResponse {
	private int cod;
	private String message;
	private int cnt;
	
	private List<Float> high_temp;
	private List<Float> low_temp;
	
	private List<String> main;
	private List<String> description;
	
}
