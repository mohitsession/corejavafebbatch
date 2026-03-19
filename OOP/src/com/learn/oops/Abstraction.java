package com.learn.oops;

public class Abstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressoMachine expressoMachine = new ExpressoMachine();
		expressoMachine.turnOn();
		expressoMachine.makeCoffee();
		
		CoffeeMachine coffeeMachine = new ExpressoMachine();
		coffeeMachine.turnOn();
		coffeeMachine.makeCoffee();
		
		System.out.println(CoffeeMachine.version);
	}

}

abstract class CoffeeMachine{
	
	public static final String version = "1.0";
	
	public abstract void makeCoffee();
	
	public void turnOn() {
		
		System.out.println("Machine is turning on");
	}
}

class ExpressoMachine extends CoffeeMachine {

	@Override
	public void makeCoffee() {
		System.out.println("Making expresso coffee");
	}
	
}

interface Printer {
	void print(Object doc);
}

class HP implements Printer{

	@Override
	public void print(Object doc) {
		// TODO Auto-generated method stub
		
	}
	
}
