package com.learn.session3;

public class OOPExample {

	public static void main(String[] args) {
		// Created the car object from Car Class
		Car car = new Car();
		
		// initilized the car object fields
		car.brandName = "Toyota";
		car.modelName = "Carola";
		car.type = "Sedan";

		// we accessed the car method
		car.printCarInfo();
		
		Car accord = new Car("Honda", "Accord", "Sedan");
		
		accord.printCarInfo();
	}
}


class Car{
	String brandName;
	String modelName;
	String type;
	
	public Car() {
	}
	
	Car(String brandName, String modelName, String type){
		this.brandName = brandName;
		this.modelName = modelName;
		this.type = type;
	}
	
	public void printCarInfo() {
		System.out.println("BrandName : "+brandName);
		System.out.println("ModelName : "+modelName);
		System.out.println("Type of Car : "+type);
	}
}