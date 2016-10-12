package com.apress.prospring2.ch08.scheduling;

import java.io.Serializable;

/**
 * @author janm
 */
public class Job implements Serializable {
    private String code;
    private boolean enabled;
    private boolean running;

    public Job(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
