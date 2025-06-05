# SpringCore_basics
spring-core dependency:
-> Foundation of Spring Framework**
-> Contains:
  * Core utilities
  * Basic dependency injection (BeanFactory)
  * Resource loading, type conversion
  * Used internally by all other Spring modules

spring-context dependency: 
-> Builds on spring-core
-> Provides:
  * Full DI container (ApplicationContext)
  * Annotation support (@Component, @Autowired, etc.)
  * Event publishing, AOP, internationalization
  * Needed for building typical Spring apps

Note: Use spring-context in most applications — it includes spring-core automatically.

=======================================================================================================================================================================

Ways of dependency injection:
| Injection Type | Spring (XML Config)                | Spring Boot (Annotation-based)            |
| -------------- | ---------------------------------- | ----------------------------------------- |
| Constructor    | <constructor-arg ref="..."/>       | @Autowired on constructor (or implicit)   |
| Setter         | <property name="..." ref="..."/>   | @Autowired on setter method               |
| Field          |  Not supported via XML             | @Autowired directly on field              |

Note: We can inject following in dependency injection
	-> Primitive datatype: byte, short, char, int, float, double, long, Boolean
	-> Collection Type: List, Set, Map and properties
	-> Reference Type: Other class object

=======================================================================================================================================================================

Practical:
1) Primitive datatype
ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
Student student1=(Student) context.getBean("student1");
Note: Here config.xml file is in src/main/resource folder
      Here student1 is name of bean in config.xml file
	<bean class="com.springcore.Student" name="student1">
		<property name="studentId" value="102" />
		<property name="studentName" value="Ram" />
		<property name="studentAddress" value="Mumbai" />
	</bean>
	Here property tag indicates setter injection

	OR
	
	<bean class="com.springcore.Student" name="student3" 
	p:studentId="103" p:studentName="Ravi" p:studentAddress="Bangalore"/>
	(for this, u have to declare 'xmlns:p="http://www.springframework.org/schema/p"' in beans in xml file>

	OR

	<bean class="com.springcore.Student" name="student2">
		<property name="studentId">
			<value>101</value>
		</property>
		
		<property name="studentName">
			<value>Sneha</value>
		</property>
		
		<property name="studentAddress">
			<value>Mangalore</value>
		</property>
	</bean>


2) Collection Type:
List:
	<bean>
		<property name="">
		<list>
			<value>10</value>
			<value>raj</value>
			<value>simran</value>
			<value>3182</value>
			<null/>(--> to insert null)
		</list>
		</property>
	</bean>

Set:
	<bean>
		<property name="">
		<set>
			<value>10</value>
			<value>1023</value>
			<value>36237</value>
			<value>3182</value>
		</set>
		</property>
	</bean>


Map:
	<bean>
		<property name="">
		<map>
			<entry key="java" value="version1"/>
			<entry key="python" value="version2"/>
			<entry key="nickname"><null/></entry>
		</map>
		</property>
	</bean>

Properties:
	<bean>
		<property name="">
		<props>
			<prop key="username">sneha</prop>
			<prop key="password">sneha123</prop>
		</props>
		</property>
	</bean>



3) Reference Type: If one class object is used in other class(In our case, Address class object is used in Employee class)
	<bean class="com.springcore.reference.Address" name="address1">
		<property name="street" value="Neeladri"/>
		<property name="city" value="E-city"/>
	</bean>
	
	<bean class="com.springcore.reference.Employee" name="employee1">
		<property name="name" value="Sneha"/>
		<property name="address" ref="address1"/>
	</bean>

	OR
	
	<bean class="com.springcore.reference.Employee" name="employee1" p:name = "Sneha" p:address-ref = "address1"/>

=======================================================================================================================================================================

Constructor Injection:
Here, Certificate object is used in Person class.(and also constructor with fields should be generated and there is no "name" field here as in <property>)
	<bean class="com.springcore.constructorinjection.Certificate" name="certificate1">
		<constructor-arg value="JavaCertificate" />
	</bean>
	
	<bean class="com.springcore.constructorinjection.Person" name="person1">
		<constructor-arg value="Sneha"/>
		<constructor-arg value="123" type="int"/>
		<constructor-arg ref="certificate1"/>
	</bean>

Setter Injection:
Here, <property> is used, and for setter injection no argument constructor to be generated to respective classes.

Constructor ambiguity:
--> Constructor ambiguity in Spring XML happens when Spring cannot clearly decide which constructor to use when multiple overloaded constructors exist in a class, 
    and your <constructor-arg> tags don’t provide enough information to help it choose.
--> index -- Position of the constructor param
    type -- Data type of the constructor param
Example: <bean class="com.springcore.constructorinjection.Addition" name="addition1">
		<constructor-arg value="12" index="1" type="int"/>
		<constructor-arg value ="13" index="0" type="java.lang.String"/>
	</bean>

=======================================================================================================================================================================

Bean lifecycle using xml file:
Init and destroy method:
--> init-method: Called after the bean is created and dependencies are injected.
--> destroy-method: Called before the bean is removed from the Spring container (during application shutdown).
Example: <bean class="com.springcore.lifecycle.Company" name="company1" 
	 init-method="init" destroy-method="destroy">
		<property name="name" value="VCTI"/>
	</bean>

Note: To call destroy() method, then (use AbstractApplicationContext and use registerShutdownHook())
	AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycleconfig.xml");
	Company company = (Company) context.getBean("company1");
	System.out.println(company);
	context.registerShutdownHook();

--> Use cases: init-method: To open resources like DB connections, start threads, preload cache.
	       destroy-method: To clean up — close files, DB connections, stop threads.


Bean lifecycle using interface:
--> init and destroy method can be implemented using interface(InitiazingBean(init method), DestroyBean(destory method))
--> example:
	public class College implements InitializingBean, DisposableBean{
	private String name;

	//getters, setter and toString()

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

Bean lifecycle using annotation:
--> init and destroy method can be implemented using @PostConstruct and @PreDestroy
--> Example:
	
	@PostConstruct
	public void start() {
		System.out.println("Init method using annotation");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Destroy method using annotation");
	}

--> In config file, u have to mention "<context:annotation-config />" to use annotations.

=======================================================================================================================================================================

Autowire:

byName: Spring matches the property name in the class with the bean name in XML.
	Example:
		<bean class="com.springcore.auto.wire.Address" name="address">
			<property name="street" value="road123"/>
			<property name="city" value="chennai" />
		</bean>
	
		<bean class="com.springcore.auto.wire.Employee" name="employee" autowire="byName" />
	--> Here, name in Address bean should be same as address in Employee class
		public class Employee {
			private Address address;
		.............
		}

byType: Spring matches the type of the property with the type of a bean. If exactly one matching type is found, it injects it.
	Note: If there are multiple beans of the same type, byType will fail with an error.
	Example:
		<bean class="com.springcore.auto.wire.Address" name="address">
			<property name="street" value="road123"/>
			<property name="city" value="chennai" />
		</bean>
	
		<bean class="com.springcore.auto.wire.Employee" name="employee" autowire="byType" />
	--> Here, it checks for type. Spring checks each property in the Employee class. For each property, it looks for a bean in the container with a matching type. 	    Finds that Employee has a property address of type Address. Finds a bean of class Address (you registered it with <bean class="...Address">)
		public class Employee {
			private Address address;
		.............
		}

constructor: Spring looks at the constructor's parameter types and tries to find matching beans by type.
	     Example:
		<bean class="com.springcore.auto.wire.Address" name="address">
			<property name="street" value="road123"/>
			<property name="city" value="chennai" />
		</bean>
	
		<bean class="com.springcore.auto.wire.Employee" name="employee" autowire="constructor" />
	    --> Here, Spring will match the Employee parameter in the constructor and inject the bean.
	        public class Employee {
			private Address address;
			public Employee(Address address) {
			super();
			this.address = address;
			}
		.............
		}

using annotation:
--> just use @Autowired above the field, setter or constructor.
--> and mention '<context:annotation-config/>' in config file

=======================================================================================================================================================================

@Qualifier:
--> @Qualifier is used with @Autowired to tell Spring which specific bean to inject when multiple beans of the same type exist.
--> Example: If u created 2 bean for Address, 
		<context:annotation-config />
		<bean class="com.springcore.auto.wire.annotation.Address" name="address1">
			<property name="street" value="1st cross"/>
			<property name="city" value="Mangalore" />
		</bean>
		<bean class="com.springcore.auto.wire.annotation.Address" name="address2">
			<property name="street" value="2nd cross"/>
			<property name="city" value="Pune" />
		</bean>
		<bean class="com.springcore.auto.wire.annotation.Employee" name="employee1"/>

		Then in Employee class, @Qualifier is used to differentiate between beans
		public class Employee {
			@Autowired
			@Qualifier("address2")
			private Address address;
			...............
		}

=======================================================================================================================================================================

Standalone Collections:
--> Standalone collections are a way to define a list, set, map, or properties independent of any bean class — directly in your XML configuration.
--> They're especially useful when:
	- You want to reuse the same collection in multiple beans
	- You need to configure complex data structures declaratively
Note: Also u can use any type of List or Map required.
Example:
	xmlns:util="http://www.springframework.org/schema/util"
	xsi:schemaLocation=......	
			   http://www.springframework.org/schema/util
			   http://www.springframework.org/schema/util/spring-util.xsd

	<util:list list-class="java.util.LinkedList" id="friends">
		<value>Sneha</value>
		<value>Akash</value>
		<value>Amit</value>
		<value>Sana</value>
	</util:list>
	
	<util:map map-class="java.util.TreeMap" id="fees">
		<entry key="Java" value="20000"/>
		<entry key="Python" value="7800"/>
		<entry key="R" value="5000"/>
		<entry key="Data structure" value="50000"/>
		
	</util:map>					   
	
	<bean class="com.springcore.standalone.collections.Person" name="person1">
		<property name="name" value="Sneha" />
		<property name="bestfriends" ref="freinds"/>
		<property name="feestructure" ref="fees"></property>
	</bean>

	public class Person {
		private String name;
		private List<String> bestfriends;
		private Map<String, Double> feestructure;
		...........
	}

=======================================================================================================================================================================

Sterotype:

@Component: To use this annotation, consider example:
@Component
public class Company{
	private String name;
	...........
}

class Main{
	...............
	Company company = (Company) context.getBean("company", Company.class);
	System.out.println(company);
}

Here in Main class, in context.getbean(), use class name in small letter and mention which class it is(eg: Company.class)
In config class,
<context:component-scan base-package=""/>
Note: No bean is created in xml file.


@Value:
But to get vales printed in output(since no bean created in xml and no value is appended in xml), use @value() annotation.
@Component
public class Company{
	
	@Value("VCTI")
	private String name;
	...........
}

but in list or map, we cant store all values in @Value annotation.
we have to create a <util-list> in config file and use that id in @Value()
Example: @Value(#{branch1})  --> this is spring expression language(spel)
<util:list list-class="java.util.LinkedList" id ="branch1">
		<value>Chennai</value>
		<value>Pune</value>
		<value>Mumbai</value>
		<value>Delhi</value>
	</util:list>

@Component
public class Company{
	
	@Value("VCTI")
	private String name;
	
	@Value("#{branch1}")
	private List<String> branch;
	...........
}
	
=======================================================================================================================================================================

@Scope:
2 ways: 1) @Scope() 2) in xml bean
Note: By default, spring supports singleton.
1) @Scope()
Example:
@Component
@Scope("prototype")
public class Company {
..........
}
Note: By using @Scope("prototype"), we can change it from singleton to prototype. Now 2 different objects will be created.

2) in xml bean
in config file:  <bean class="com.springcore.sterotype.Home" name="home1" scope="prototype"/>
public class Home {

}
in main class:
Home home1 = (Home) context.getBean("home1");
		Home home2 = (Home) context.getBean("home1");
		System.out.println(home1.hashCode());
		System.out.println(home2.hashCode());

=======================================================================================================================================================================

Static methods and Variables using Spring expression language(spel) & Boolean value:

using @Value annotation:
Syntax: static method -> T(class).method(parameters)
	static variable -> T(class).variable

Example:
@Component
public class Demo {
	
	@Value("#{ T(java.lang.Math).sqrt(144)}")
	private double sqrt;
	
	@Value("#{ T(java.lang.Math).PI}")
	private double pi;
	
	@Value("#{ 8-4>2}")
	private boolean isActive;
}

=======================================================================================================================================================================
Without xml:
2 ways: 1) using @Component(above class) and @ComponentScan
	2) using @Bean(above method, which return object)
1)
Note: You have to create a class, that shld be annotated with @Configurable and @ComponentScan(basePackages="")
Example:
@Configuration
@ComponentScan(basePackages="com.springcore.config")
public class Javaconfig {

}

@Component
public class Student {
	
	public void study() {
		System.out.println("The student is studying");
	}

}

main class, use AnnoationConfigApplicationContext() with config class name as parameter.
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Javaconfig.class);
		Student student = context.getBean("student", Student.class);
		student.study();
	}

}

2) @Bean
@Configuration
public class Javaconfig {
	
	@Bean
	public Student getStudent() {
		return new Student();
	}
}

public class Student {
	
	public void study() {
		System.out.println("The student is studying");
	}

}

main class:
ApplicationContext context = new AnnotationConfigApplicationContext(Javaconfig.class);
		Student student = context.getBean("getStudent",Student.class);  --> here. getStudnet is method name to which @Bean is annotated.
		student.study();
Note: check com.springcore.config for more reference




