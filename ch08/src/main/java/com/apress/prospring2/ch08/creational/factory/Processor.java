package com.apress.prospring2.ch08.creational.factory;

/**
 * @author janm
 */
public interface Processor {

    Processed convert(byte[] source);

}
