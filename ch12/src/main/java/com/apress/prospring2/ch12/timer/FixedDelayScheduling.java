package com.apress.prospring2.ch12.timer;

import java.util.Timer;

public class FixedDelayScheduling {

	public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new HelloWorldTask(), 1000, 3000);
	}
}
