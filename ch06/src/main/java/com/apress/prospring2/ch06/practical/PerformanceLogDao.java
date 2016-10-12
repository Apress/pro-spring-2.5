package com.apress.prospring2.ch06.practical;

/**
 * @author janm
 */
public interface PerformanceLogDao {
    void insert(PerformanceLog performanceLog, long time);
}
