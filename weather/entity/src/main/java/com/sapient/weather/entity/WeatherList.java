package com.sapient.weather.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WeatherList {

	@JsonProperty("dt")
	private Date dt;
	
	
	@Autowired
	MainList main;
	
	@Autowired
	List<Weather> weather; 
	
	@Autowired
	Clouds clouds;
	
	@Autowired 
	Wind wind;
	
	@JsonProperty("visibility")
	private int visibility;
	@JsonProperty("pop")
	private float pop;
	
	@Autowired
	Rain rain;
	
	@Autowired
	Sys sys;
	
	@JsonProperty("dt_txt")
	private String dt_txt;

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public MainList getMain() {
		return main;
	}

	public void setMainList(MainList main) {
		this.main = main;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public void setMain(MainList main) {
		this.main = main;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public float getPop() {
		return pop;
	}

	public void setPop(float pod) {
		this.pop = pod;
	}

	public Rain getRain() {
		return rain;
	}

	public void setRain(Rain rain) {
		this.rain = rain;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	} 
	
}
