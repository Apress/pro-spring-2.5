package com.apress.prospring2.ch06.practical;

/**
 * @author janm
 */
public interface ExceptionLogDao {


    void insert(ExceptionLog exceptionLog, Throwable exception);
}
