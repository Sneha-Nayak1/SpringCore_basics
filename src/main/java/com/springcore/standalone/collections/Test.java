package com.springcore.standalone.collections;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("standaloneconfig.xml");
		Person person = (Person) context.getBean("person1");
		System.out.println(person);
		System.out.println(person.getBestfriends().getClass().getName());
		System.out.println(person.getFeestructure().getClass().getName());
		
	}
}
