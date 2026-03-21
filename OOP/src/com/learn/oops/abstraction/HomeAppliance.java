package com.learn.oops.abstraction;

public abstract class HomeAppliance implements SmartDevice {

	protected boolean isOn = false;
	
	@Override
	public void turnOn() {
		this.isOn = true;
		System.out.println("Powering On");
	}
	
	@Override
	public void turnOff() {
		this.isOn = false;
		System.out.println("Powering Off");
	}
	
	
	public abstract void performTask();
	
}
