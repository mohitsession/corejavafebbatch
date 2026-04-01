package com.learn.example2;

public class Counter {
	private int count =0;
	public synchronized void increment() {
//		synchronized {

			count++;	
//		}
	}
	
	public int getCount() {
		return count;
	}
}
