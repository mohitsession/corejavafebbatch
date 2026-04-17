package com.learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonConstructorInjection {
	private String name;
	private String age;
	private String city;

	public PersonConstructorInjection(@Value("Kumar") String name, @Value("35") String age,
			@Value("Milpitas") String city) {
//		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}
