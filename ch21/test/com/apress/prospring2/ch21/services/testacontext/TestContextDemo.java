package com.apress.prospring2.ch21.services.testacontext;

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author Aleksa Vukotic
 */
@TestExecutionListeners(value = DependencyInjectionTestExecutionListener.class)
public class TestContextDemo {
}
