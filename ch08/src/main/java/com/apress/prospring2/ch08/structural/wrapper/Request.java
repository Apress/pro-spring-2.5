package com.apress.prospring2.ch08.structural.wrapper;

/**
 * @author janm
 */
public interface Request {

    String getAction();

    Object getArgument(String name);

}
