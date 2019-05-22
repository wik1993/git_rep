package com.decoratorPattern;

public abstract class ShapeDecorator implements Shape {

    protected Shape decoratorShape;

    protected ShapeDecorator (Shape decoratorShape){
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }
}
