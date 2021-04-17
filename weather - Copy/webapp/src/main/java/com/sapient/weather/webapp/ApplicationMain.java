package com.sapient.weather.webapp;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.collect.ImmutableSet;

@ComponentScan(basePackages = {"com.sapient.weather"})
@SpringBootApplication
public class ApplicationMain {
	private static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";
	private static final ImmutableSet<String> VALID_ENVIRONMENTS = ImmutableSet.of("local","cloud");
	
	public static void main(String[] args) {
		if (new ApplicationMain().validateProfile())
			SpringApplication.run(ApplicationMain.class, args);
	}

	private boolean validateProfile() {
		String activeProfile = System.getProperty(SPRING_PROFILES_ACTIVE);
		if(StringUtils.isEmpty(activeProfile)) {
			System.out.println("Spring activeProfile not specified !, set JVM parameter -Dspring.profiles.active");
			return false;
		}
		if (!VALID_ENVIRONMENTS.contains(activeProfile)) {
			System.out.println(activeProfile + "; Invalid 'spring.profiles.active' specified !, valid environments are : " + VALID_ENVIRONMENTS.toString());
			return false;
		}
		return true;
	}
}
