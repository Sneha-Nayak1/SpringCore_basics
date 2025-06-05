package com.springcore.reference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("referenceconfig.xml");
		Employee employee=(Employee) context.getBean("employee1");
		System.out.println(employee);

	}

}
