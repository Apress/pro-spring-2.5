package com.apress.prospring2.ch08.structural.proxy;

import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * @author janm
 */
public class RealSimpleDao implements SimpleDao {
    private List<String> greetings = new LinkedList<String>();

    public void insert(String greeting) {
        Assert.hasText(greeting, "The greeting argument must contain some text.");
        this.greetings.add(greeting);
    }

    public List<String> getAll() {
        return this.greetings;
    }
}
