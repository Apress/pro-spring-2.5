package com.apress.prospring2.ch08.creational.builder;

/**
 * @author janm
 */
public class HouseBuildingCompany {

    public House build(HouseBuilder builder) {
        builder.buildBasement();
        builder.buildWalls();
        builder.buildRoof();
        return builder.getHouse();
    }

}
