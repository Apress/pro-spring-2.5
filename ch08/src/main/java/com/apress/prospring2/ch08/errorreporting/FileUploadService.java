package com.apress.prospring2.ch08.errorreporting;

/**
 * @author janm
 */
public interface FileUploadService {
    
    void upload(String username, String mimeType, long level, byte[] content);

}
