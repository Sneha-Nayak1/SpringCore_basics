package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//lifecycle using interface
public class College implements InitializingBean, DisposableBean{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "College [name=" + name + "]";
	}

	@Override
	public void destroy() throws Exception {
		// destroy method
		System.out.println("Destroy method using Interface");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// init method
		System.out.println("Init method using Interface");
		
	}
	
	

}
