package com.apress.prospring2.ch03.dm;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author janm
 */
public class DownloadManager {
    private static final Pattern URI_PATTERN = Pattern.compile("^([^:]*):/(.*)$");
    private Map<String, Downloader> downloaders;

    public static void main(String[] args) throws IOException {
        XmlBeanFactory xbf = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/downloadmanager-context.xml"));
        DownloadManager dm = (DownloadManager)xbf.getBean("downloadManager");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String uri = reader.readLine();
            if (uri.length() == 0) break;
            dm.download(uri);
        }
    }

    private void download(String uri) {
        Matcher matcher = URI_PATTERN.matcher(uri);
        if (matcher.matches()) {
            String scheme = matcher.group(1);
            String path = matcher.group(2);
            Downloader downloader = this.downloaders.get(scheme);
            if (downloader != null) {
                downloader.download(path);
            }
        }
    }

    public void setDownloaders(Map<String, Downloader> downloaders) {
        this.downloaders = downloaders;
    }
}
