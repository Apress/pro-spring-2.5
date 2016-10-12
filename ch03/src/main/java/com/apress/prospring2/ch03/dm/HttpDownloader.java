package com.apress.prospring2.ch03.dm;

import org.springframework.stereotype.Component;

/**
 * @author janm
 */
@Component
public class HttpDownloader implements Downloader {
    public byte[] download(String uri) {
        System.out.println("HTTP Downloading " + uri);
        return new byte[0];
    }
}
