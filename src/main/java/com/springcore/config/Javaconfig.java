package com.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.springcore.config")
public class Javaconfig {
	
	@Bean
	public Student getStudent() {
		return new Student();
	}
}
