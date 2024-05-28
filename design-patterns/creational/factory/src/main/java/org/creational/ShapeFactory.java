package org.creational;

public class ShapeFactory {
    public static IShape getShape(String shapeType) {
        IShape shape = null;
        switch (shapeType) {
            case "circle":
                return new Circle();

            case "square":
                return new Square();

            default:
                throw new IllegalArgumentException("Invalid shape type: " + shapeType);
        }
    }
}
