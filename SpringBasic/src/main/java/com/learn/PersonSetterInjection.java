package com.learn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonSetterInjection {
	private String name;
	private String age;
	private String city;

	public PersonSetterInjection() {
		// TODO Auto-generated constructor stub
	}

	public PersonSetterInjection(String name, String age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	@Value("Sham")
	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	@Value("31")
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
