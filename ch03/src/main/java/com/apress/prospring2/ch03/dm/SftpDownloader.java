package com.apress.prospring2.ch03.dm;

import org.springframework.stereotype.Component;

/**
 * @author janm
 */
@Component
public class SftpDownloader implements Downloader {
    public byte[] download(String uri) {
        System.out.println("SFTP Downloading " + uri);
        return new byte[0];
    }
}
