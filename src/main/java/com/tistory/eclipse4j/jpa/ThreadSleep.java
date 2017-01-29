package com.tistory.eclipse4j.jpa;

public class ThreadSleep {
	public static void sleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
}
