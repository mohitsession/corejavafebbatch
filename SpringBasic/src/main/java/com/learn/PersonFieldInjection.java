package com.learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonFieldInjection {
	@Value("Rohan")
	private String name;
	@Value("40")
	private String age;
	@Value("New York")
	private String city;

	public PersonFieldInjection() {
		// TODO Auto-generated constructor stub
	}

	public PersonFieldInjection(String name, String age, String city) {
		super();
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
