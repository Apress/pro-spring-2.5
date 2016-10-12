package com.apress.prospring2.ch11.dataaccess;

import com.apress.prospring2.ch11.domain.LogEntry;

import java.util.List;

/**
 * @author janm
 */
public interface LogEntryDao {

    LogEntry getById(Long id);

    LogEntry getByName(String name);

    void save(LogEntry logEntry);

    List<LogEntry> getAll();

}
