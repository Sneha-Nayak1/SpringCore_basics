package com.springcore.collections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("collectionConfig.xml");
		Emp emp=(Emp) context.getBean("emp1");
		System.out.println(emp);
	}

}
