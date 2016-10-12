package com.apress.prospring2.ch12.timer.bday;

import org.springframework.scheduling.timer.ScheduledTimerTask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BirthdayScheduledTask extends ScheduledTimerTask {

	private static final long MILLIS_IN_YEAR = 1000 * 60 * 60 * 24 * 365;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date startDate;

	public void setDate(String date) throws ParseException {
		startDate = dateFormat.parse(date);
	}

	@Override
	public long getDelay() {
		Calendar now = Calendar.getInstance();
		Calendar then = Calendar.getInstance();
		then.setTime(startDate);

		return (then.getTimeInMillis() - now.getTimeInMillis());
	}

	@Override
	public long getPeriod() {
		return MILLIS_IN_YEAR;
	}

}
