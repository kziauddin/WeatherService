package com.sapient.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainList {

	@JsonProperty("temp")
	private float temp;
	@JsonProperty("feels_like")
	private float feels_like;
	@JsonProperty("temp_min")
	private float temp_min;
	@JsonProperty("temp_max")
	private float temp_max;
	@JsonProperty("pressure")
	private int pressure;
	@JsonProperty("sea_level")
	private int sea_level;
	@JsonProperty("grnd_level")
	private int grnd_level;
	@JsonProperty("humidity")
	private int humidity;
	@JsonProperty("temp_kf")
	private float temp_kf;
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(float feels_like) {
		this.feels_like = feels_like;
	}
	public float getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}
	public float getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getSea_level() {
		return sea_level;
	}
	public void setSea_level(int sea_level) {
		this.sea_level = sea_level;
	}
	public int getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(int grnd_level) {
		this.grnd_level = grnd_level;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getTemp_kf() {
		return temp_kf;
	}
	public void setTemp_kf(float temp_kf) {
		this.temp_kf = temp_kf;
	}
	
	
}
