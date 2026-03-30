package com.learn.exceptions;

public class InsufficientFundsException extends Exception {
	
	private double amount;
	
	public InsufficientFundsException(double amount) {
		super("Insufficient FUnds $ "+amount);
		this.amount = amount;
	}

}
