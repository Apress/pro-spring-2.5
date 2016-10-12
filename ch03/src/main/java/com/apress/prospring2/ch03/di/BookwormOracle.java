package com.apress.prospring2.ch03.di;

/**
 * @author janm
 */
public class BookwormOracle implements Oracle {
    private Encyclopedia encyclopedia;

    public String defineMeaningOfLife() {
        Long ageOfUniverse = this.encyclopedia.findLong("AgeOfUniverse");
        Long constantOfLife = this.encyclopedia.findLong("ConstantOfLife");
        return String.valueOf(ageOfUniverse / constantOfLife);
    }

    public void setEncyclopedia(Encyclopedia encyclopedia) {
        this.encyclopedia = encyclopedia;
    }
}
