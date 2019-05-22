package com.decoratorPattern;

import com.decoratorPattern.shapes.Circle;
import com.decoratorPattern.shapes.Rectangle;


public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape rectangle = new Rectangle();

        Shape redCircle = new RedShapeDecorator(circle);

        Shape redRectangle = new RedShapeDecorator(rectangle);

        System.out.println("\nCircle with normal border");
        circle.draw();

        System.out.println("\nCircle with red border");
        redCircle.draw();

        System.out.println("\nRectangle with normal border");
        rectangle.draw();

        System.out.println("\nRectangle with red border");
        redRectangle.draw();
    }
}
