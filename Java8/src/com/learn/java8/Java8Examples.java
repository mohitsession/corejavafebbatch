package com.learn.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Java8Examples {

	public static void main(String[] args) {
		Example example = new Example();
		Thread t1 = new Thread(example);

		Thread t2 = new Thread(() -> System.out.println("Processing using Lambda"));

		Thread t3 = new Thread(() -> {
			System.out.println("Processing using Lambda");
			System.out.println("Another print");
		});
		t3.start();

		t1.start();

		t2.start();

		System.out.println();
		// Consumer functional interface
		Consumer<String> trimAndUpperCase = s -> {
			s = s.trim();
			s = s.toUpperCase();
			System.out.println(s);
		};

		trimAndUpperCase.accept(" rohan ");

		// Supplier

		Supplier<Double> randomNumber = () -> Math.random();

		System.out.println("Randomm Number is " + randomNumber.get());

		// Function

		Function<String, String> transformString = s -> {
			s = s.trim();
			return s.toLowerCase();
		};

		System.out.println(transformString.apply(" Sham "));

		Function<String, Integer> length = s -> s.length();

		System.out.println(length.apply("Hello"));
	}

}

class Example implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Processing");
	}

}