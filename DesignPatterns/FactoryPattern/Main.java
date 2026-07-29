package FactoryPattern;

import FactoryPattern.ShapeFactory.ShapeFactory;
import FactoryPattern.Shapes.ShapeInterface;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();
        ShapeInterface circle=shapeFactory.getShape("CIRCLE");
        ShapeInterface square=shapeFactory.getShape("SQUARE");
        ShapeInterface rectangle=shapeFactory.getShape("RECTANGLE");
        ShapeInterface triangle=shapeFactory.getShape("TRIANGLE");
        circle.shape();
        square.shape();
        rectangle.shape();
        triangle.shape();
    }
}
