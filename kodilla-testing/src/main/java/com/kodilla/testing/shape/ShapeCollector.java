package com.kodilla.testing.shape;

import com.kodilla.testing.forum.ForumPost;

import java.util.ArrayList;
import java.util.Objects;

public class ShapeCollector {
    private String name;
    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public ShapeCollector(String name) {
        this.name = name;
    }

    public void addFigure(Shape shape){
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if(figures.contains(shape)){
            figures.remove(shape);
            result = true;
        }
        
        return result;
    }

    public Shape getFigure(int n){
        Shape figure = null;
        if(n >= 0 && n < figures.size()){
            figure = figures.get(n);
        }

        return figure;
    }

    public void showFigures(){
        if(figures.size() > 0){
            for(Shape shape : figures){
                System.out.println(shape);
            }
        }else{
            System.out.println("The collector is empty.");
        }
    }

    public int getFiguresQuantity(){
        return figures.size();
    }

    public boolean containsFigure(Shape figure){
        return figures.contains(figure);
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
