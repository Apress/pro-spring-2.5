package com.apress.prospring2.ch08.errorreporting;

import org.springframework.core.NestedRuntimeException;

/**
 * @author janm
 */
public class FileUploadException extends NestedRuntimeException {

    public FileUploadException(String msg) {
        super(msg);
    }

    public FileUploadException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
