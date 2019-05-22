package com.decoratorPattern.shapes;

import com.decoratorPattern.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
