package com.sapient.weather.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherWebResponse {
	private int cod;
	private String message;
	private int cnt;
	private List<String> dt;
	
	private List<Float> high_temp;
	private List<Float> low_temp;
	
	private List<String> main;
	private List<String> description;
	private List<Integer> id;
	private List<String> icon;
	private List<String> advice;
	
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
	public List<Float> getHigh_temp() {
		return high_temp;
	}
	public void setHigh_temp(List<Float> high_temp) {
		this.high_temp = high_temp;
	}
	public List<Float> getLow_temp() {
		return low_temp;
	}
	public void setLow_temp(List<Float> low_temp) {
		this.low_temp = low_temp;
	}
	public List<String> getMain() {
		return main;
	}
	public void setMain(List<String> main) {
		this.main = main;
	}
	public List<String> getDescription() {
		return description;
	}
	public void setDescription(List<String> description) {
		this.description = description;
	}
	public List<String> getDt() {
		return dt;
	}
	public void setDt(List<String> dt) {
		this.dt = dt;
	}
	public List<String> getAdvice() {
		return advice;
	}
	public void setAdvice(List<String> advice) {
		this.advice = advice;
	}
	public List<Integer> getId() {
		return id;
	}
	public void setId(List<Integer> id) {
		this.id = id;
	}
	public List<String> getIcon() {
		return icon;
	}
	public void setIcon(List<String> icon) {
		this.icon = icon;
	}
	
	
}
