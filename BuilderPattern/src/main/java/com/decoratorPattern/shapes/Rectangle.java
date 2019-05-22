package com.decoratorPattern.shapes;

import com.decoratorPattern.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle ");
    }
}
