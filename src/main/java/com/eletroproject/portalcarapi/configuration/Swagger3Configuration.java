package com.eletroproject.portalcarapi.configuration;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Configuration {
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("com.eletroproject")
				.pathsToMatch("/api/cars/**", "/api/brands/**")
				.build();
	}
}
