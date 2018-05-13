package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape{
    private double side;
    private double height;

    public Triangle(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public double getField() {
        return (side*height)/2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side, side) == 0 &&
                Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(side, height);
    }
}
