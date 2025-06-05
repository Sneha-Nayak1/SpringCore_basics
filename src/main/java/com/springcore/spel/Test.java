package com.springcore.spel;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;


public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spelconfig.xml");
		Demo demo = context.getBean("demo", Demo.class);
		System.out.println(demo);
	}
}
