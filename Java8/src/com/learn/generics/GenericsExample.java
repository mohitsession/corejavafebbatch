package com.learn.generics;

import java.util.ArrayList;

public class GenericsExample {

	public static void main(String[] args) {

		// without generics
		ArrayList oldList = new ArrayList();
		oldList.add("Rohan");
		oldList.add(123);
		String s = (String) oldList.get(0);
//		String s1 = (String) oldList.get(1);
		System.out.println(s.toUpperCase());
		
		// With Generics
		ArrayList<String> list = new ArrayList<>();
		list.add("Rohan");
//		list.add(123); // Compile time error : Type mismatch
		
		
//		Box<String> stringBox = new Box<>("Sham");
		
//		System.out.println(stringBox.getContent());
	
		Box<Integer> num = new Box<>(123);
		Box<Short> num2 = new Box(25);
//		Box<String> num3 = new Box(123);
	}

}


class Box<T extends Number> {
	private T content;
	
	public Box(T content) {
		this.content = content;
	}
	
	T getContent() {
		return content;
	}
	
	void setContent(T content) {
		this.content = content;
	}
}