package com.apress.prospring2.ch21.dataaccess.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author Aleksa Vukotic
 */
public class InvalidResultException extends DataAccessException {
    public InvalidResultException(String message) {
        super(message);
    }

    public InvalidResultException(String message, Throwable throwable) {
        super(message, throwable);
    }


}
