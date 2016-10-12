package com.apress.prospring2.ch11.service;

import com.apress.prospring2.ch11.dataaccess.LogEntryDao;
import com.apress.prospring2.ch11.domain.LogEntry;

import java.util.Calendar;

/**
 * @author janm
 */
public class LoggingSampleService implements SampleService {
    private LogEntryDao logEntryDao;

    private void log(String message) {
        LogEntry entry = new LogEntry();
        entry.setDate(Calendar.getInstance().getTime());
        entry.setName(message);
        this.logEntryDao.save(entry);
    }

    public void work() {
        log("Begin.");
        log("Processing...");

        if (System.currentTimeMillis() % 2 == 0) log(null);
        log("Done.");
    }

    public void setLogEntryDao(LogEntryDao logEntryDao) {
        this.logEntryDao = logEntryDao;
    }
}
