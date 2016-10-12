package com.apress.prospring2.ch08.structural.proxy;

import java.util.List;

/**
 * @author janm
 */
public interface SimpleDao {

    void insert(String greeting);

    List<String> getAll();

}
