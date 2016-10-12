package com.apress.prospring2.ch12.timer;

import java.util.TimerTask;

public class HelloWorldTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Hello World!");
	}
}
