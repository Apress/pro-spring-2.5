package com.apress.prospring2.ch08.errorreporting;

import org.springframework.util.Assert;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author janm
 */
public class DefaultFileUploadService implements FileUploadService {
    private static final String ALLOWED_MIME_TYPE = "text/plain";
    private static final Log logger = LogFactory.getLog(DefaultFileUploadService.class);

    public void upload(String username, String mimeType, long level, byte[] content) {
        Assert.hasText(username, "The username argument is empty or null.");
        Assert.hasText(mimeType, "The mimeType argument is emoty or null.");
        Assert.notNull(content, "The content argument must not be null.");

        if (level % 11 == 0) throw new InvalidLevelException("Level must not be divisible by 11.");
        if (!ALLOWED_MIME_TYPE.equals(mimeType)) {
            throw new FileFormatException("Invalid file format. Expected " + ALLOWED_MIME_TYPE + " got " + mimeType);
        }

        logger.debug("Processing started.");
        // prepare
        logger.debug("Uploading for level " + level);
        if (level % 2 == 0) logger.warn("Modulo-2 level found!");
        // do something here.
        logger.debug("Done.");
    }
}
