package com.apress.prospring2.ch08.creational.builder;

/**
 * @author janm
 */
public class BuilderDemo {

    public static void main(String[] args) {
        HouseBuilder builder = new SimpleHouseBuilder();
        HouseBuildingCompany houseBuildingCompany = new HouseBuildingCompany();
        House house = houseBuildingCompany.build(builder);
        System.out.println(house);
    }

}
