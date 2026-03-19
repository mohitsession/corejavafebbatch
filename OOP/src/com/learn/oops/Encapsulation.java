package com.learn.oops;

public class Encapsulation {

	public static void main(String[] args) {

		BankAccount account = new BankAccount(1000, "Ram");
		System.out.println("Account balance of " + account.name + " is " + account.getBalance());

		// Below wont work because we created the name as final 
		// account.name = "Sham";
		
		account.deposit(500);
		System.out.println("500 has been deposited");
		System.out.println("Account balance of " + account.name + " is " + account.getBalance());
		
		account.deposit(-500);
		System.out.println("-500 has been deposited");
		System.out.println("Account balance of " + account.name + " is " + account.getBalance());
		
		//this demostation
		account.printBalance(2000);
	}

}

class BankAccount {

	// Hiding data
	private double balance;
	public final String name;

	public BankAccount(double balance, String name) {
		this.balance = balance;
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
		}
	}
	
	public void printBalance(double balance) {
		System.out.println("Balance : "+balance);
		System.out.println("Balance : "+this.balance);
	}
}
