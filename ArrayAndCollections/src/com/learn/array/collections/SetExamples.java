package com.learn.array.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExamples {

	public static void main(String[] args) {

		HashSet<String> fruits = new HashSet<String>();

		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Cherry");

		System.out.println(fruits);

		fruits.add("Banana");
		System.out.println(fruits);

		Set<String> fruits2 = new LinkedHashSet<String>();

		fruits2.add("Banana");
		fruits2.add("Apple");
		fruits2.add("Cherry");

		System.out.println(fruits2);

		fruits2.add("Banana");
		System.out.println(fruits2);

		Set<Integer> treeSet = new TreeSet<Integer>();

		treeSet.add(10);
		treeSet.add(5);
		treeSet.add(100);

		System.out.println(treeSet);

		// List 1 -> 1,2,3,4,5
		// List 2 -> 3,4,5,6,7

		HashSet<Integer> setA = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		HashSet<Integer> setB = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));

		HashSet<Integer> union = new HashSet<>(setA);
		union.addAll(setB); // 1,2,3,4,5,6,7

		System.out.println("Union of set A and B : " + union);

		HashSet<Integer> intersection = new HashSet<Integer>(setA);
		intersection.retainAll(setB);
		System.out.println("Intersection of A and B : "+intersection);

	}

}
