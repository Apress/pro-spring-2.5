package com.apress.prospring2.mock;

import org.jmock.core.Invocation;
import org.jmock.core.matcher.InvokedRecorder;
import org.junit.Assert;

/**
 * @author janm
 */
public class InvokeTimesMatcher extends InvokedRecorder {

	private int actualCount = 0;
	private int expectedCount;

	public InvokeTimesMatcher(final int expectedCount) {
		this.expectedCount = expectedCount;
	}

	@Override
	public void invoked(Invocation invocation) {
		super.invoked(invocation);
		actualCount++;
	}

	@Override
	public void verify() {
		if (actualCount != expectedCount) {
			Assert.assertEquals("Invoked " + actualCount + " times, but expected " + expectedCount + " times.", expectedCount, actualCount);
		}
	}

}
