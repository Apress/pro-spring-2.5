package com.apress.prospring2.ch03.di;

import org.springframework.util.Assert;

import java.util.Map;

/**
 * @author janm
 */
public class ConfigurableEncyclopedia implements Encyclopedia {
    private Map<String, Long> entries;

    public ConfigurableEncyclopedia(Map<String, Long> entries) {
        Assert.notNull(entries, "The 'entries' argument cannot be null.");
        this.entries = entries;
    }

    public Long findLong(String entry) {
        return this.entries.get(entry);
    }
}
