package com.apress.prospring2.ch08.creational.builder;

/**
 * @author janm
 */
public class SimpleHouseBuilder implements HouseBuilder {
    private House house;

    public SimpleHouseBuilder() {
        this.house = new House();
    }

    public void buildBasement() {
        this.house.setBasement(new House.Basement());
    }

    public void buildWalls() {
        for (int i = 0; i < 4; i++) this.house.addWall(new House.Wall());
    }

    public void buildRoof() {
        this.house.setRoot(new House.Roof());
    }

    public House getHouse() {
        return this.house;
    }
}
