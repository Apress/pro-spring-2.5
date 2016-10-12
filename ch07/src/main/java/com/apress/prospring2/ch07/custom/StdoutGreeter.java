package com.apress.prospring2.ch07.custom;

/**
 * @author anirvanc
 */
public class StdoutGreeter implements Greeter {
	private int count;
	private String message;

	public StdoutGreeter(final int count, final String message) {
		this.count = count;
		this.message = message;
	}

	public void greet() {
		System.out.println("Showing message number: " + count);
		System.out.println(message);
	}

}

