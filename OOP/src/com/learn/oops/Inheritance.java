package com.learn.oops;

public class Inheritance {

	public static void main(String[] args) {
		Car car = new Car("Honda", 4);
		System.out.println("Car Brand is " + car.getBrand());
		car.printCarInfo();
		
		Vehicle vehicle = new Vehicle("Generic");
		vehicle.setBrand("newBrand");
		
		// below wont work because the field in Vehicle is marked as private
		// vehicle.brand = "newBrand";
	}

}

class Vehicle {

	private String brand;
	private String speed;

	public Vehicle(String brand) {
		this.brand = brand;
		System.out.println("Constructor of Vehicle");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

}

class Car extends Vehicle {

	private int noOfDoors;

	public Car(String brand, int noOfDoors) {
		super(brand);
		System.out.println("Constructor of Car");
		this.noOfDoors = noOfDoors;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public void printCarInfo() {
		System.out.println("Car Brand is " + getBrand() + ", number of doors is " + noOfDoors);
	}
}

class Bike extends Vehicle {

	private int noOfGears;

	public Bike(String brand) {
		super(brand);
		System.out.println("Constructor of Bike");
	}

	public int getNoOfGears() {
		return noOfGears;
	}

	public void setNoOfGears(int noOfGears) {
		this.noOfGears = noOfGears;
	}

}
