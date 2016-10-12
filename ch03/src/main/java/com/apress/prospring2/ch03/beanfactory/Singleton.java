package com.apress.prospring2.ch03.beanfactory;

/**
 * @author janm
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }
}
