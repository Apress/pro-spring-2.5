package com.apress.prospring2.ch03.dm;

/**
 * @author janm
 */
public interface Downloader {

    byte[] download(final String uri);

}
