package com.springcore.sterotype;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sterotypeconfig.xml");
		Company company = (Company) context.getBean("company", Company.class);
		Company company1 = (Company) context.getBean("company", Company.class);
		System.out.println(company.hashCode());
		System.out.println(company1.hashCode());
		System.out.println("=======================================");
		Home home1 = (Home) context.getBean("home1");
		Home home2 = (Home) context.getBean("home1");
		System.out.println(home1.hashCode());
		System.out.println(home2.hashCode());
		
		
		
	}

}
