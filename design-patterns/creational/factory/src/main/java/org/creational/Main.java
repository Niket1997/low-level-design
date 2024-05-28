package org.creational;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        IShape circle = ShapeFactory.getShape("circle");
        circle.calculateArea();
    }
}