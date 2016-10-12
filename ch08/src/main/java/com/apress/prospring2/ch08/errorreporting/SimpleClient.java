package com.apress.prospring2.ch08.errorreporting;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author janm
 */
public class SimpleClient {
    private FileUploadService fileUploadService;
    private static final Log logger = LogFactory.getLog(SimpleClient.class);
    private static final byte[] CONTENT = new byte[] { 1, 2, 3 };

    public void uploadTerrible() {
        try {
            this.fileUploadService.upload("me", "text/plain", System.currentTimeMillis() % 50, CONTENT);
        } catch (Exception e) {
            // Go away!
        }
    }

    public void uploadBetter() {
        try {
            this.fileUploadService.upload("me", "text/plain", System.currentTimeMillis() % 50, CONTENT);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void setFileUploadService(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
}
