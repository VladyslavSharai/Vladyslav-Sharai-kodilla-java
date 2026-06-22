package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape){
    shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
    return shapes.remove(shape);
    }

    public Shape getFigure(int n){
    if(n>=0 && n<shapes.size()){
        return shapes.get(n);
    }
    return null;
    }

    public String showFigures(){
    List<String> names = new ArrayList<>();
    for(Shape shape:shapes){
        names.add(shape.getShapeName());
    }
        return String.join(", ", names);
    }
}
