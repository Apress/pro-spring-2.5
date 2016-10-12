package com.apress.prospring2.ch12.timer;

import java.util.Calendar;
import java.util.Timer;

public class SimpleBirthdayReminderScheduling {

	private static final long MILLIS_IN_YEAR = 1000 * 60 * 60 * 24 * 365;

	public static void main(String[] args) {
		Timer t = new Timer();

		Calendar cal = Calendar.getInstance();
		cal.set(2005, Calendar.NOVEMBER, 30);
		t.schedule(new HelloWorldTask(), cal.getTime());

		t.scheduleAtFixedRate(new HelloWorldTask(), cal.getTime(), MILLIS_IN_YEAR);
	}
}
