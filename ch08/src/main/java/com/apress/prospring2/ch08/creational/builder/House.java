package com.apress.prospring2.ch08.creational.builder;

import java.util.List;
import java.util.LinkedList;

/**
 * @author janm
 */
public class House {
    public static class Basement {
        @Override
        public String toString() {
            return "Basement";
        }
    }
    public static class Wall {
        @Override
        public String toString() {
            return "Wall";
        }
    }
    public static class Roof {
        @Override
        public String toString() {
            return "Roof";
        }
    }

    private Basement basement;
    private List<Wall> walls;
    private Roof roof;

    public House() {
        this.walls = new LinkedList<Wall>();
    }

    public void addWall(Wall wall) {
        this.walls.add(wall);
    }

    public void setRoot(Roof roof) {
        this.roof = roof;
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("House {").append(this.basement);
        sb.append(", ").append(this.walls);
        sb.append(", ").append(this.roof).append("}");
        return sb.toString();
    }
}
