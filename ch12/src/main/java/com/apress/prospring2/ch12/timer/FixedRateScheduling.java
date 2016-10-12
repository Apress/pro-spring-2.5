package com.apress.prospring2.ch12.timer;

import java.util.Timer;

public class FixedRateScheduling {

	public static void main(String[] args) {
		Timer t = new Timer();
		t.scheduleAtFixedRate(new HelloWorldTask(), 1000, 1000);
	}
}
