package com.learn.session3;

public class Loops {

	public static void main(String[] args) {

		// While Loop

		/*
		 * Syntax while(condition){ // Block of code that should be executed multiple
		 * times }
		 * 
		 * 
		 */
		System.out.println("--------------------- While Loop --------------------");
		int count = 1;
		while (count <= 5) {
			System.out.println("The count is " + count);
			count++;
		}
		System.out.println("Loop Finished!");

		// For Loop
		System.out.println("--------------------- For Loop --------------------");
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}

		System.out.println("Print Even Number");
		for (int i = 2; i <= 20; i += 2) {
			System.out.print(i + " ");
		}

		// Nested Loop for multiplication table
		System.out.println("\n Nested Loop for multiplication table");
		for (int i = 2; i <= 3; i++) {
			System.out.println("Table of " + i);
			for (int j = 1; j <= 10; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}

		// Do while loop

		/*
		 * do{ Block of code } while (condition);
		 */

		boolean isPersonTired = true;

		do {
			System.out.println("Person is not tired (using do while loop)");
		} while (!isPersonTired);

		while (!isPersonTired) {
			System.out.println("Person is not tired (using while loop)");
		}

		// break

		System.out.println("Example of Break");
		int counter = 1;
		while (counter <= 10) {
			System.out.println("Counter : " + counter);
			if (counter == 5) {
				break;
			}
			counter++;
		}

		System.out.println("Example of Continue");
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0)
				continue;
			System.out.print(i + " ");
			// 100
		}

		// Methods

		System.out.println("Example of Methods");

		greet("Ram");
		
		int addition = add(2,3);
		System.out.println(addition);
		
		int addition1 = add(3, 3);
		System.out.println(addition1);
		
	}

	private static void greet(String name) {
		System.out.println("Hello " + name);
	}

	private static int add(int a, int b) {
		return a + b;
	}
}
