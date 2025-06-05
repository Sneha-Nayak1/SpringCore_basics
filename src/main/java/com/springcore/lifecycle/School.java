package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//lifecycle using annotations
public class School {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("Init method using annotation");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Destroy method using annotation");
	}

}
