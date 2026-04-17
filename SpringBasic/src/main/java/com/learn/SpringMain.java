package com.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person = applicationContext.getBean(Person.class);
		Person person2 = applicationContext.getBean(Person.class);

		person.setName("Ram");
		person.setAge("30");
		person.setCity("Fremont");


		person2.setName("KUMAR");
		person2.setAge("39");
		person2.setCity("Huston");
		
		System.out.println(person);

		System.out.println(person2);
		

		applicationContext.getBean(Student.class);

		PersonSetterInjection personSetterInjection = applicationContext.getBean(PersonSetterInjection.class);

		System.out.println(personSetterInjection);

		PersonFieldInjection fieldInjection = applicationContext.getBean(PersonFieldInjection.class);

		System.out.println(fieldInjection);

		PersonConstructorInjection constructorInjection = applicationContext.getBean(PersonConstructorInjection.class);
		System.out.println(constructorInjection);
		// if you are using constructor injection that bean should not have default constructor
		
		AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) applicationContext;
		abstractApplicationContext.close();
	}

}
