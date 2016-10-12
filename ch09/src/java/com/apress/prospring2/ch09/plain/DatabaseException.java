package com.apress.prospring2.ch09.plain;

import org.springframework.core.NestedRuntimeException;

/**
 * @author janm
 */
class DatabaseException extends NestedRuntimeException {

    DatabaseException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

}
