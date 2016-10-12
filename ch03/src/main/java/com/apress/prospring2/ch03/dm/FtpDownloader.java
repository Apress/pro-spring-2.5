package com.apress.prospring2.ch03.dm;

import org.springframework.stereotype.Component;

/**
 * @author janm
 */
@Component
public class FtpDownloader implements Downloader {
    public byte[] download(String uri) {
        System.out.println("FTP Downloading " + uri);
        return new byte[0];
    }
}
