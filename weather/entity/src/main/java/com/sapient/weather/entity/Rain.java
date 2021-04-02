package com.sapient.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {

	@JsonProperty("3h")
	private float Threeh;

	public float getThreeh() {
		return Threeh;
	}

	public void setThreeh(float threeh) {
		Threeh = threeh;
	}

	
}
