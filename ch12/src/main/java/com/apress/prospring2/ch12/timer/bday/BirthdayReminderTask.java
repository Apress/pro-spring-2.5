package com.apress.prospring2.ch12.timer.bday;

import java.util.TimerTask;

public class BirthdayReminderTask extends TimerTask {

	private String who;

	public void setWho(final String who) {
		this.who = who;
	}

	@Override
	public void run() {
		System.out.println("Don't forget it is "
				+ who + "'s birthday in 7 days");
	}
}
