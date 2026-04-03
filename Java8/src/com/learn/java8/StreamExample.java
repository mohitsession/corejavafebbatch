package com.learn.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Ram", "Sham", "Rohan", "Bob", "Bob", "Manoj", "Harshal", "Kumar");

		List<String> result = new ArrayList<String>();

		for (String name : names) {
			if (name.length() > 3) {
				String upper = name.toUpperCase();
				result.add(upper);
			}
			if (result.size() >= 3)
				break;
		}
		
		System.out.println(result);

		List<String> resultUsingStream = names.stream()
				.filter(n -> n.length() > 3)
				.map(s -> 
				s.toUpperCase()).limit(3)
				.collect(Collectors.toList());
		
		// for debugging
		List<String> resultUsingStream1 = names.stream().filter(n -> {
			boolean result2 = n.length() > 3;
			System.out.println(result2);
			return result2;
		}).map(s -> s.toUpperCase()).limit(3).collect(Collectors.toList());

		names.stream().filter(n -> n.length() > 3).map(s -> s.toUpperCase()).limit(3)
				.forEach(s -> System.out.println(s));

		List<String> names2 = names.stream().distinct().collect(Collectors.toList());
		System.out.println(names2);
	}

}
