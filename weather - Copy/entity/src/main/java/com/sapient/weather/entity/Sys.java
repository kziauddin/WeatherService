package com.sapient.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys {
	@JsonProperty("pod")
	private String pod;

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}
	
}
