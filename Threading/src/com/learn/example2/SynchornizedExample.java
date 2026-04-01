package com.learn.example2;

import java.util.Iterator;

public class SynchornizedExample {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		Task task = new Task(counter);

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		
		System.out.println("Counter value : " + counter.getCount());
	}

}
