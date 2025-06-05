package com.springcore.lifecycle;

public class Company {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Calling setter method");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + "]";
	}
	
	public void init() {
		System.out.println("Init Method, any name is fine");
	}
	
	public void destroy() {
		System.out.println("Destroy method, any name is fine");
	}
	

}
