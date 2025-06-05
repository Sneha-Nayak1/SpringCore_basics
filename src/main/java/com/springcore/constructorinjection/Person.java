package com.springcore.constructorinjection;

public class Person {
	
	private String name;
	private int id;
	private Certificate certificate;
	
	
	
	public Person(String name, int id, Certificate certificate) {
		super();
		this.name = name;
		this.id = id;
		this.certificate = certificate;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", certificate=" + certificate + "]";
	}
	
	

}
