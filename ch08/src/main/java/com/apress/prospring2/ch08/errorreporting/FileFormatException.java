package com.apress.prospring2.ch08.errorreporting;

/**
 * @author janm
 */
public class FileFormatException extends FileUploadException {

    public FileFormatException(String msg) {
        super(msg);
    }
}
