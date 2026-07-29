package FactoryPattern.ShapeFactory;

import FactoryPattern.Shapes.Circle;
import FactoryPattern.Shapes.Rectangle;
import FactoryPattern.Shapes.ShapeInterface;
import FactoryPattern.Shapes.Square;
import FactoryPattern.Shapes.Triangle;

public class ShapeFactory {
    public ShapeInterface getShape(String name){
        ShapeInterface shape;
        if(name=="CIRCLE")
            shape=new Circle();
        else if(name=="SQUARE")
            shape=new Square();
        else if(name=="RECTANGLE")
            shape=new Rectangle();
        else
            shape=new Triangle();
        return shape;
    }
}
