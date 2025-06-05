package com.springcore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Student {
	@Autowired
	private College college;
	
	
	public void study() {
		college.display();
		System.out.println("The student is studying");
	}

}
