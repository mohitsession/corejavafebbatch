package com.learn.array;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {

		int[] scores = new int[5];
		scores[2] = 80;
		scores[0] = 90;
//		scores[1] = "false";

		System.out.println("Score of element 3 : " + scores[2]);

		for (int i = 0; i < scores.length; i++) {
			System.out.println("score of " + i + " is " + scores[i]);
		}

		String[] days = { "Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat" };

		double[] prices = new double[] { 100.1, 999.99, 199.99 };

		System.out.println("Size of days " + days.length);

		// foreach
		for (String day : days) {
			System.out.println("Day is " + day);
		}

//		System.out.println("price of 4th element " + prices[13]);

		Arrays.sort(prices);

		for (double price : prices) {
			System.out.println("Sorted prices array : " + price);
		}

		String[] copyOfDays = Arrays.copyOf(days, days.length);
		Arrays.sort(copyOfDays);
		System.out.println(Arrays.toString(copyOfDays));
		System.out.println(Arrays.toString(days));

		// 2D array
		int[][] matrix = new int[3][4];

		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(grid[1][2]);

		// This will iterate over row
		for (int i = 0; i < grid.length; i++) {
			// this will iterate over column
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		for (int[] row : grid) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

}
