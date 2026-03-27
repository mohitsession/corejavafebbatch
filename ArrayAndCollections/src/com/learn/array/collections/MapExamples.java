package com.learn.array.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
	public static void main(String[] args) {
		Map<String, Integer> scores = new HashMap<String, Integer>();

		scores.put("ram", 95);
		scores.put("Sham", 87);
		scores.put("Kumar", 92);
//		scores.put("Rohan", null);

		System.out.println(scores.get("ram"));

		scores.put("ram", 98);
		System.out.println(scores.get("ram"));

		scores.put("Ram", 100);

		System.out.println(scores);

		System.out.println("Score of Rohan " + scores.getOrDefault("Rohan", 0));
		System.out.println("Score of ram " + scores.getOrDefault("ram", 0));

		System.out.println(scores.containsKey("ram"));
		System.out.println(scores.containsValue(90));

		scores.remove("Kumar");

		System.out.println(scores);

		// using Keys

		for (String name : scores.keySet()) {
			System.out.println(name + " score is " + scores.get(name));
		}

		// values only
		for (int score : scores.values()) {
			System.out.println(score);
		}

		// Best way
		for (Map.Entry<String, Integer> entry : scores.entrySet()) {
			System.out.println(entry.getKey() + " score is " + entry.getValue());
		}
		
		scores.putIfAbsent("Sham", 100);
		scores.putIfAbsent("Bob", 100);
		
		System.out.println(scores);
		
		Map<String, Integer> scores2 = new LinkedHashMap<String, Integer>();
		scores2.put("ram", 95);
		scores2.put("Sham", 87);
		scores2.put("Kumar", 92);
		System.out.println("LinkedHashMap : "+ scores2);
		
		Map<String,Integer> scores3 = new TreeMap<String, Integer>();
		scores3.put("ram", 95);
		scores3.put("Sham", 87);
		scores3.put("Kumar", 92);
		System.out.println("TreeMap : "+ scores3);
	}
}
