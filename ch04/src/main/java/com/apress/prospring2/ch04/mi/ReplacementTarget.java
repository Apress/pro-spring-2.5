package com.apress.prospring2.ch04.mi;

/**
 * @author janm
 */
public class ReplacementTarget {

    public String formatMessage(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>").append(msg).append("</h1>");
        return sb.toString();
    }

    public String formatMessage(Object msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>").append(msg).append("</h1>");
        return sb.toString();
    }
}
