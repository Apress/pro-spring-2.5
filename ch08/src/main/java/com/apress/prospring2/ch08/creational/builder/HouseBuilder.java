package com.apress.prospring2.ch08.creational.builder;

/**
 * @author janm
 */
public interface HouseBuilder {

    void buildBasement();

    void buildWalls();

    void buildRoof();
    
    House getHouse();

}
