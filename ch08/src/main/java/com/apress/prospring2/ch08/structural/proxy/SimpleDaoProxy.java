package com.apress.prospring2.ch08.structural.proxy;

import org.springframework.util.Assert;

import java.util.List;

/**
 * @author janm
 */
public class SimpleDaoProxy implements SimpleDao {
    private SimpleDao target;

    public SimpleDaoProxy(SimpleDao target) {
        Assert.notNull(target, "The target argument cannot be null.");
        this.target = target;
    }

    private void begin() {
        System.out.println("* begin");
    }

    private void rollback() {
        System.out.println("* rollback");
    }

    private void commit() {
        System.out.println("* commit");
    }

    public void insert(String greeting) {
        begin();
        try {
            this.target.insert(greeting);
            commit();
        } catch (RuntimeException e) {
            rollback();
            throw e;
        }
    }

    public List<String> getAll() {
        return this.target.getAll();
    }
}
