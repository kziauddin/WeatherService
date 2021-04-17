package com.sapient.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListWeatherRequest {
	@JsonProperty("q")
	private String q;
	
	@JsonProperty("appId")
	private String appId;
	
	@JsonProperty("mode")
	private String mode;
	
	@JsonProperty("cnt")
	private int cnt;
	
	@JsonProperty("units")
	private String units;
	
	@JsonProperty("lang")
	private String lang;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	
}
