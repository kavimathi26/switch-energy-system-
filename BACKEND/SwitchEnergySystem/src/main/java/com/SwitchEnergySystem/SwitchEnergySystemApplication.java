package com.SwitchEnergySystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@CrossOrigin("*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableScheduling
public class SwitchEnergySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwitchEnergySystemApplication.class, args);
	}

	@Bean

	public WebMvcConfigurer corsConfigurer()
	{
		String[] allowDomains = new String[1];
		allowDomains[0] = "http://localhost:4200";
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(allowDomains);
			}
		};
	}
	@Bean
	public WebMvcConfigurer corsConfigurer1() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
						.allowCredentials(true);
			}
		};
	}
}
