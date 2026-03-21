package com.learn.oops.abstraction;

public class AbstractionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartWM smartWM = new SmartWM();
		
		smartWM.turnOn(); 
		smartWM.performTask();
		
		smartWM.turnOff();
		smartWM.performTask();
	}

}
