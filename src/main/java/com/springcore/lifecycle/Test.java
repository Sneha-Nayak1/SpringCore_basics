package com.springcore.lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycleconfig.xml");
		Company company = (Company) context.getBean("company1");
		System.out.println(company);
		College college = (College) context.getBean("college1");
		System.out.println(college);
		
		School school = (School) context.getBean("school");
		System.out.println(school);
		context.registerShutdownHook();
		
		

	}

}
