package com.sapient.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord {
	@JsonProperty("lat")
	private float lat;
	@JsonProperty("lon")
	private float lon;
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	
	
}
