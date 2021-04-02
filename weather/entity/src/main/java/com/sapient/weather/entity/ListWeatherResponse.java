package com.sapient.weather.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListWeatherResponse implements Serializable {
	@JsonProperty("cod")
	private int cod;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("cnt")
	private int cnt;
	
	@JsonProperty("list")
	private List<WeatherList> weatherList; 

	@JsonProperty("city")
	City city;

	
	public ListWeatherResponse() {
		super();
	}

	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	public List<WeatherList> getWeatherList() {
		return weatherList;
	}

	public void setWeatherList(List<WeatherList> weatherList) {
		this.weatherList = weatherList;
	}

	
}
