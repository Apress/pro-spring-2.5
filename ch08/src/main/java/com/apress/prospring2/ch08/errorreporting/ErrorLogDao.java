package com.apress.prospring2.ch08.errorreporting;

import java.util.List;

/**
 * @author janm
 */
public interface ErrorLogDao {
    
    void insert(String stackTrace, String method);

    List<ErrorLog> getAll();
}
