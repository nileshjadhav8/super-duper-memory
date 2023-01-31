package com.nus.dayone;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class DayoneApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DayoneApplication.class);

		String port = "8080";

		ApplicationArguments cliopts = new DefaultApplicationArguments(args);

		if (cliopts.containsOption("port"))
			port = cliopts.getOptionValues("port").get(0);

		app.setDefaultProperties(Collections.singletonMap("server.port", port));

		System.out.printf("Starting application on port %n", port);
		

		app.run(args);
	}
/* 
	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;

	}
*/
}
