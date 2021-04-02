package com.sapient.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
	@JsonProperty("speed")
	private float speed;
	@JsonProperty("deg")
	private float degree;
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getDegree() {
		return degree;
	}
	public void setDegree(float degree) {
		this.degree = degree;
	}
	
	
}
