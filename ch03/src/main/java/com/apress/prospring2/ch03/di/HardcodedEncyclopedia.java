package com.apress.prospring2.ch03.di;

import java.util.Map;
import java.util.HashMap;

/**
 * @author janm
 */
public class HardcodedEncyclopedia implements Encyclopedia {
    private Map<String, Long> entryValues = new HashMap<String, Long>();

    public HardcodedEncyclopedia() {
        this.entryValues.put("AgeOfUniverse", 13700000000L);
        this.entryValues.put("ConstantOfLife", 326190476L);
    }

    public Long findLong(String entry) {
        return this.entryValues.get(entry);
    }
}
