package com.apress.prospring2.ch08.errorreporting;

/**
 * @author janm
 */
public class InvalidLevelException extends FileUploadException {

    public InvalidLevelException(String msg) {
        super(msg);
    }
}
