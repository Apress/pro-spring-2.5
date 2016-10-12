package com.apress.prospring2.ch08.errorreporting;

/**
 * @author janm
*/
public class ErrorLog {
    private String stackTrace;
    private String method;
    private int count = 1;

    public ErrorLog(String stackTrace, String method) {
        this.stackTrace = stackTrace;
        this.method = method;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public String getMethod() {
        return method;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.count).append(" * ");
        sb.append(this.method).append(", Stack trace").append(this.stackTrace);
        return sb.toString();
    }
}
