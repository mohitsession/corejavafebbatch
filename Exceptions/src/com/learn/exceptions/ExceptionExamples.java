package com.learn.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class ExceptionExamples {

	public static void main(String[] args) {

		try {
			int result = 10 / 2;
			System.out.println(result);

			String[] names = { "Ram", "Sham" };
			System.out.println("Name " + names[1]); // This will throw IndexOutOfBoundsException

//			String name = null;
//			System.out.println(name.toUpperCase());

		} catch (ArithmeticException ex) {
			System.out.println("ArithmeticException Caught : " + ex.getMessage());
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("IndexOutOfBoundsException Caught : " + ex.getMessage());
		} catch (ClassCastException ex) {
			System.out.println("Exception Caught : " + ex.getMessage());
		} finally {
			// This will get executed in happy path and exception path

			System.out.println("Finally always run!");
		}

		try {
			int result = 10 / 2;
			System.out.println(result);

			String[] names = { "Ram", "Sham" };
			System.out.println("Name " + names[1]); // This will throw IndexOutOfBoundsException

		} catch (ArithmeticException | IndexOutOfBoundsException ex) {
			System.out.println("Caught : " + ex.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
		}

//		try {
//			readFile("xyz");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			validateAge(0);
//		} catch (IllegalArgumentException e) {
//			System.out.println(e.getMessage());
//		}
//		

		try {
			double fund = 5;
			if (fund < 10) {
				throw new InsufficientFundsException(10);
			}
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}

		System.out.println("Program Ended");
	}

	public static String readFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner sc = new Scanner(file);
		return "";
	}

	public static void validateAge(int age) throws IllegalArgumentException {
		if (age < 18) {
			throw new IllegalArgumentException("Age cannot be less than 18");
		}
	}

}
