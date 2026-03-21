package com.learn.array.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList genericList = new ArrayList();

		genericList.add(123);
		genericList.add(true);
		genericList.add("apple");
		genericList.add('A');

		System.out.println(genericList);

		ArrayList<String> fruits = new ArrayList<>();

//		fruits[0] = "Apple";
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Cherry");

		System.out.println(fruits.get(0));
		System.out.println("Size of Fruits arraylist is " + fruits.size());
		
		fruits.remove(1);
		fruits.remove("Banana"); // this will never give error
		System.out.println(fruits);
		
		
		System.out.println(fruits.contains("Apple"));
		
		Collections.sort(fruits);
		
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
	}
}
