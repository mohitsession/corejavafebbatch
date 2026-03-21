package com.learn.oops.abstraction;

public class SmartWM extends HomeAppliance {

	@Override
	public void connectToWifi() {
		System.out.println("Connecting to wifi");
	}

	@Override
	public void performTask() {
		String stateOfMachine = isOn ? "On" : "Off";
		System.out.println("State of Washing Machine : "+ stateOfMachine);
	}

}
