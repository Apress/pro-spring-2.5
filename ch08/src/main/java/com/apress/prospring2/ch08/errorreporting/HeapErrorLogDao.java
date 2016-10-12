package com.apress.prospring2.ch08.errorreporting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author janm
 */
public class HeapErrorLogDao implements ErrorLogDao {

    private List<ErrorLog> errors = Collections.synchronizedList(new LinkedList<ErrorLog>());

    public void insert(String stackTrace, String method) {
        for (ErrorLog log : this.errors) {
            if (log.getMethod().equals(method) &&
                    log.getStackTrace().equals(stackTrace)) {
                log.setCount(log.getCount() + 1);
                return;
            }
        }
        this.errors.add(new ErrorLog(stackTrace, method));
    }

    public List<ErrorLog> getAll() {
        return this.errors;
    }
}
