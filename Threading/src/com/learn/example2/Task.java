package com.learn.example2;

public class Task implements Runnable {
	
	private Counter counter;
	
	public Task(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for(int i =0; i<=10000; i++) {
			counter.increment();
		}
	}
}
