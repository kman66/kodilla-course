package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.Objects;

public class ShapeCollector {
    private String name;
    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public ShapeCollector(String name) {
        this.name = name;
    }

    public void addFigure(Shape shape){

    }

    public boolean removeFigure(Shape shape){
        return true;
    }

    public Shape getFigure(int n){
        return null;
    }

    public void showFigures(){

    }

    public int getFiguresQuantity(){
        return 100;
    }

    public boolean containsFigure(Shape figure){
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeCollector that = (ShapeCollector) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
